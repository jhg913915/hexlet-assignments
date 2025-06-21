package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN
    @Test
    public void testShow() throws Exception {
        Task task = Instancio.of(Task.class)
                .create();

        task = taskRepository.save(task);

        var result = mockMvc.perform(get("/tasks/" + task.getId()))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        Task finalTask = task;
        Task finalTask1 = task;
        Task finalTask2 = task;
        assertThatJson(body).and(
                a -> a.node("id").isEqualTo(finalTask1.getId()),
                a -> a.node("title").isEqualTo(finalTask.getTitle()),
                a -> a.node("description").isEqualTo(finalTask2.getDescription())
        );
    }

    @Test
    public void testCreate() throws Exception {
        Task task = Instancio.of(Task.class)
                .ignore(Select.field("id"))
                .create();

        var result = mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(task)))
                .andExpect(status().isCreated())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).and(
                a -> a.node("title").isEqualTo(task.getTitle()),
                a -> a.node("description").isEqualTo(task.getDescription())
        );
    }

    @Test
    public void testUpdate() throws Exception {
        Task task = Instancio.of(Task.class)
                .create();

        task = taskRepository.save(task);

        Task updatedTask = Instancio.of(Task.class)
                .ignore(Select.field("id")) // Игнорируем поле id
                .create();

        var result = mockMvc.perform(put("/tasks/" + task.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(updatedTask)))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        Task finalTask = task;
        assertThatJson(body).and(
                a -> a.node("id").isEqualTo(finalTask.getId()),
                a -> a.node("title").isEqualTo(updatedTask.getTitle()),
                a -> a.node("description").isEqualTo(updatedTask.getDescription())
        );
    }

    @Test
    public void testDelete() throws Exception {
        Task task = Instancio.of(Task.class)
                .create();
        task = taskRepository.save(task);

        mockMvc.perform(delete("/tasks/" + task.getId()))
                .andExpect(status().isOk());

        // Проверяем, что задача была удалена
        mockMvc.perform(get("/tasks/" + task.getId()))
                .andExpect(status().isNotFound());
    }

    private HashMap<String, String> createTaskMap(Task task) {
        HashMap<String, String> taskMap = new HashMap<>();
        taskMap.put("title", task.getTitle());
        taskMap.put("description", task.getDescription());
        return taskMap;
    }
    // END
}

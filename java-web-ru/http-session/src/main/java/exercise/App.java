package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            List<Map<String, String>> users = Data.getUsers();
            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            int startIndex = (page - 1) * per;
            int endIndex = Math.min(startIndex + per, USERS.size());
            List<Map<String, String>> usersOnPage = new ArrayList<>();
            if (startIndex < USERS.size()) {
                usersOnPage = USERS.subList(startIndex, endIndex);
            }
            ctx.json(usersOnPage);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

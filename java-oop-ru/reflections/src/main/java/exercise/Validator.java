package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> invalidFields = new ArrayList<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if(field.isAnnotationPresent(NotNull.class)){
                try {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if(value == null){
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    System.err.println("Error accessing fiel d: " + field.getName() + ": " + e.getMessage());
                }
            }
        }
        return invalidFields;
    }
}
// END

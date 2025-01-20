package exercise;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> originalData = storage.toMap();
        Map<String, String> swappedData = new HashMap<>();
        for (Map.Entry<String, String> entry : originalData.entrySet()) {
            String key = entry.getValue();
            String value = entry.getKey();
            int i = 1;
            while (swappedData.containsKey(key)) {
                key = entry.getValue() + "_" + i++;
            }
            swappedData.put(key, value);
        }
        for (Map.Entry<String, String> entry : originalData.entrySet()) {
            storage.unset(entry.getKey());
        }
        for (Map.Entry<String, String> entry : swappedData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}


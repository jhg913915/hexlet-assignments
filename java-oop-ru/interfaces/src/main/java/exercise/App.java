package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int elements) {
        List<String> result = new ArrayList<>();
        homes.sort(Comparator.comparing(Home::getArea));
        if (elements > homes.size()) {
            elements = homes.size();
        }
        for (int i = 0; i < elements; i++) {
            result.add(homes.get(i).toString());
        }
        return result;
    }
}
// END

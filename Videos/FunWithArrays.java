package Videos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunWithArrays {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Benjamin", "Benson");
        System.out.println(names.size());

        String[] moreNames = {"Mordecai", "Rigby", "Pops"};
        System.out.println(moreNames.length);

        System.out.println(names);
        System.out.println(moreNames); // jibberish
        // names.add("Rigby"); // error
    }
}

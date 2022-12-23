package IntStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartesianProduct {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(2, 6));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 4, 2));

        var p = a.stream().map(item -> b.stream().map(itemB -> new int[] {item, itemB}));
    }
}

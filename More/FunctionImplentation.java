package More;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionImplentation {
    public <T, R> List<R> map(List<T> original, Function<T, R> f) {
        List<R> toReturn = new ArrayList<>();

        for (T item: original) {
            toReturn.add(f.apply(item));
        }

        return toReturn;
    }

    public static void main(String[] args) {
        FunctionImplentation fi = new FunctionImplentation();
        System.out.println(fi.map(Arrays.asList("Coldplay", "Radiohead", "Autechre", "Billie Eilish"), (String item) -> item.length()));
    }
}

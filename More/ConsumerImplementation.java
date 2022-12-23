package More;

import java.util.Arrays;
import java.util.List;

public class ConsumerImplementation {
    public <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t: list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        ConsumerImplementation ci = new ConsumerImplementation();
        ci.forEach(Arrays.asList(1, 2, 3), (Integer value) -> System.out.println("Value " + value));
    }
}

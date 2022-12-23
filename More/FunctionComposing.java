package More;

public class FunctionComposing {
    public static void main(String[] args) {
        java.util.function.Function<Integer, Integer> f = x -> x + 1;
        java.util.function.Function<Integer, Integer> g = x -> x * 5;
        java.util.function.Function<Integer, Integer> h = f.andThen(g);
        java.util.function.Function<Integer, Integer> i = f.compose(g);

        System.out.println(h.apply(4));
        System.out.println(i.apply(4));
    }
}

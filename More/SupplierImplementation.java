package More;

import Apples.Colour;

public class SupplierImplementation {
    public static void main(String[] args) {
        Supplier<Apple> s1 = () -> new Apple(40, Colour.GREEN);
        Supplier<Apple> s2 = Apple::new;
        Apple a1 = s1.provide();
        Apple a2 = s2.provide();
        a2.setWeight(50);

        System.out.println(a1);
        System.out.println(a2);
    }
}

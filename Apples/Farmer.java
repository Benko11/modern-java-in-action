package Apples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Farmer {
    // attempt 1
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        ArrayList<Apple> filtered = new ArrayList<>();
        for (Apple apple: inventory) {
            if (apple.getColour().equals(Colour.GREEN))
                filtered.add(apple);
        }

        return filtered;
    }

    // attempts 2
    public static List<Apple> filterApplesByColour(List<Apple> inventory, Colour colour) {
        ArrayList<Apple> filtered = new ArrayList<>();
        for (Apple apple: inventory) {
            if (apple.getColour().equals(colour))
                filtered.add(apple);
        }

        return filtered;
    }

    // we are breaking DRY (Don't Repeat Yourself)
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        ArrayList<Apple> filtered = new ArrayList<>();
        for (Apple apple: inventory) {
            if (apple.getWeight() > weight)
                filtered.add(apple);
        }

        return filtered;
    }

    // attempt 3 (the worst one so far)
    public static List<Apple> filterApplesByWeightOrColour(List<Apple> inventory, Colour colour, int weight, boolean flag) {
        ArrayList<Apple> filtered = new ArrayList<>();
        for (Apple apple: inventory) {
            if (flag) {
                if (apple.getColour().equals(colour))
                    filtered.add(apple);

                continue;   
            }

            if (apple.getWeight() > weight)
                filtered.add(apple);
        }

        return filtered;
    }

    // attempt 4 - behaviour parametrization
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> filtered = new ArrayList<>();

        for (Apple apple: inventory) {
            if (p.test(apple))
                filtered.add(apple);
        }

        return filtered;
    }

    // exercise
    public static void prettyPrintApple(List<Apple> inventory, ApplePrinter p) {
        for (Apple apple: inventory) {
            String output = p.parseApple(apple);
            System.out.println(output);
        }
    }

    // attempt 7
    public static <T> List<T> filter(List<T> items, Predicate<T> p)  {
        List<T> filtered = new ArrayList<>();
        for (T item: items) {
            if (p.test(item)) {
                filtered.add(item);
            }
        }

        return filtered;
    }

    public static <T> void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Colour.GREEN, 100));
        inventory.add(new Apple(Colour.GREEN, 200));
        inventory.add(new Apple(Colour.RED, 180));
        inventory.add(new Apple(Colour.RED, 90));
        inventory.add(new Apple(Colour.RED, 110));

        System.out.println(filterGreenApples(inventory));
        System.out.println(filterApplesByColour(inventory, Colour.RED));
        System.out.println(filterApplesByWeight(inventory, 150));
        System.out.println(filterApplesByWeightOrColour(inventory, null, 100, false));
        System.out.println(filterApplesByWeightOrColour(inventory, Colour.RED, 0, true));

        System.out.println(filterApples(inventory, apple -> apple.getWeight() > 150 && apple.getColour().equals(Colour.RED)));
        System.out.println(filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return apple.getWeight() > 150 && apple.getColour().equals(Colour.GREEN);
            }
        }));

        prettyPrintApple(inventory, apple -> String.valueOf(apple.getWeight()));
        prettyPrintApple(inventory, new ApplePrinter() {
            @Override
            public String parseApple(Apple apple) {
                return apple.getWeight() > 150 ? "HEAVY" : "LIGHT";
            }
        });
        prettyPrintApple(inventory, new AppleHumanPrinter());

        // inventory.sort(new Comparator<Apple>() {
        //     @Override
        //     public int compare(Apple apple1, Apple apple2) {
        //         return apple1.getWeight().compareTo(apple2.getWeight());
        //     }
        // });

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        prettyPrintApple(inventory, apple -> apple.toString());
    }
}

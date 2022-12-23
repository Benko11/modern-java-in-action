package Apples;
public class AppleGreenColourPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColour().equals(Colour.GREEN);
    }
}

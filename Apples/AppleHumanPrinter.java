package Apples;
public class AppleHumanPrinter implements ApplePrinter {
    @Override
    public String parseApple(Apple apple) {
        Integer threshold = 150;
        StringBuffer output = new StringBuffer();

        if (apple.getWeight() > threshold) {
            output.append("heavy ");
        } else {
            output.append("light ");
        }

        if (apple.getColour().equals(Colour.GREEN)) {
            output.append("green ");
        } else {
            output.append("red ");
        }

        output.append("apple");
        return output.toString();
    }
}

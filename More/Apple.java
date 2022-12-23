package More;

import Apples.Colour;

public class Apple {
    private Integer weight;
    private Colour colour;

    public Apple() {}

    public Apple(Integer weight, Colour colour) {
        this.weight = weight;
        this.colour = colour;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return weight + "g " + (Colour.GREEN.equals(colour) ? "green" : "red") + " apple";
    }
}

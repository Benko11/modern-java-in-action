package Apples;

public class Apple {
    private Colour colour;
    private Integer weight;

    public Apple() {}

    public Apple(Colour colour, Integer weight) {
        this.colour = colour;
        this.weight = weight;
    }

    public Colour getColour() {
        return this.colour;
    }
    
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple: (" + colour + ", " + weight + ")";
    }
}
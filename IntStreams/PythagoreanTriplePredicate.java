package IntStreams;

import java.util.function.Predicate;

public class PythagoreanTriplePredicate implements Predicate<Triple> {
    @Override
    public boolean test(Triple triple) {
        return (Math.pow(triple.getA(), 2) + Math.pow(triple.getB(), 2)) == Math.pow(triple.getC(), 2);
    }
}

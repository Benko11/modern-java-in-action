package IntStreams;

import java.util.function.Predicate;

public class PythagoreanTriplePrecedentPredicate implements Predicate<Triple> {
    @Override
    public boolean test(Triple triple) {
        return Math.sqrt(triple.getA() * triple.getA() + triple.getB() * triple.getB()) % 1 == 0;
    }
    
}

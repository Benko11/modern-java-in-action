package Collectors;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class IntegerSumCollector implements Collector<Integer, int[], Integer> {
    @Override
    public Supplier<int[]> supplier() {
        return () -> new int[1];
    }

    @Override
    public BiConsumer<int[], Integer> accumulator() {
        return (acc, item) -> acc[0] += item;
    }

    @Override
    public BinaryOperator<int[]> combiner() {
        return (acc1, acc2) -> {
            acc1[0] += acc2[0];
            return acc1;
        };
    }

    @Override
    public Function<int[], Integer> finisher() {
        return (acc) -> acc[0];
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}

package Streams.Exam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;


public class Test {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );
        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Transaction> t1 = transactions.stream().filter(t -> t.getYear() == 2011).collect(Collectors.toList());
        t1.sort(comparing(Transaction::getValue).reversed());
        System.out.println(t1);

        List<String> t2 = traders.stream().map(t -> t.getCity()).distinct().collect(Collectors.toList());
        System.out.println(t2);

        List<Trader> t3 = traders.stream().filter(t -> t.getCity().equals("Cambridge")).collect(Collectors.toList());
        t3.sort(comparing(Trader::getName));
        System.out.println(t3);

        String t4 = traders.stream().map(t -> t.getName()).reduce("", (a, b) -> a + " " + b).toString();
        System.out.println(t4);

        boolean t5 = traders.stream().anyMatch(t -> t.getCity().equals("Milan"));
        System.out.println(t5);

        transactions.stream().map(t -> t.getValue()).reduce(Integer::max).ifPresent(System.out::println);

        transactions.stream().map(t -> t.getValue()).reduce(Integer::min).ifPresent(minimum -> {
            Transaction t8 = transactions.stream().filter(t -> t.getValue() == minimum).collect(Collectors.toList()).get(0);
            System.out.println(t8);
        });
    }
}

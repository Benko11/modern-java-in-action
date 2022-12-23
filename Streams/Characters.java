package Streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Characters {
    public static void main(String[] args) {
        List<String> characters = new ArrayList<>();
        characters.add("Nigel Ratburn");
        characters.add("Harold McBride");
        characters.add("Homer Simpson");

        Stream<String> s = characters.stream();

        s.forEach(System.out::println);
        // stream is consumed, error
        try {
            s.forEach(System.out::println);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        Iterator<String> i = characters.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        // terminal operation does not return a stream
    }
}

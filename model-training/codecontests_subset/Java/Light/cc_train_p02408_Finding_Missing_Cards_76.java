

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> cards = new ArrayList<>();
        Stream.of('S', 'H', 'C', 'D')
              .forEach(c -> {
                  IntStream.rangeClosed(1, 13)
                           .forEach(n -> {
                               cards.add(c + " " + n);
                           });
              });
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while(sc.hasNext()) {
            String card = sc.nextLine();
            cards.remove(card);
        }
        cards.forEach(c -> {
            System.out.println(c);
        });
    }
}


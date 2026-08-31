import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    int n = sc.nextInt();

    Map<String, Set<Integer>> cards = new LinkedHashMap<>();
    Arrays.asList("S", "H", "C", "D").forEach(pattern -> {
        cards.put(pattern, new TreeSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13)));
    });

    IntStream.range(0, n).forEach(i ->  cards.get(sc.next()).remove(sc.nextInt()));
    
    cards.forEach((p, nums) -> nums.forEach(x -> pw.println(p + " " + x)));

    pw.flush();
    sc.close();
  }
}

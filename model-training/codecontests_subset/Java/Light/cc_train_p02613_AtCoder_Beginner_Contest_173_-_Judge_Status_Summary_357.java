import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());

        Map<String, List<String>> data = IntStream.range(0, n)
                .mapToObj(i -> scanner.nextLine())
                .collect(Collectors.groupingBy(e -> e));

        Arrays.stream(new String[]{"AC", "WA", "TLE", "RE"})
                .forEach(e -> System.out.println(e + " x "
                        + data.getOrDefault(e, Collections.emptyList()).size()));
    }
}

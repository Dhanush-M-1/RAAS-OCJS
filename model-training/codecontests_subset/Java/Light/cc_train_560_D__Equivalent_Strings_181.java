import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();

        List<String> input = IntStream.range(0, 2)
                .mapToObj(i -> sc.nextLine())
                .collect(Collectors.toList());


        solve(input);
    }

    private static void solve(List<String> input) {

        String s1 = smallest(input.get(0));
        String s2 = smallest(input.get(1));

        if (s1.equals(s2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static String smallest(String s) {
        int l = s.length();
        if (l % 2 == 1) return s;

        String s1 = smallest(s.substring(0, l / 2));
        String s2 = smallest(s.substring(l/2, l));

        if (s1.compareTo(s2) <= 0) {
            return s1.concat(s2);
        } else {
            return s2.concat(s1);
        }
    }

}
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B479 {
    public static void main(String[] args) throws Throwable {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final String line = scanner.nextLine();
        final Map<String, Integer> s = new HashMap<>();
        String dMaxS = null;
        int dMaxD = 0;

        for (int i = 0; i < line.length() - 1; i++) {
            final String d = line.substring(i, i + 2);

            if (!s.containsKey(d)) {
                s.put(d, 1);

                if (1 > dMaxD) {
                    dMaxD = 1;
                    dMaxS = d;
                }
            } else {
                s.put(d, s.get(d) + 1);

                if (s.get(d) > dMaxD) {
                    dMaxD = s.get(d);
                    dMaxS = d;
                }
            }
        }

        System.out.println(dMaxS);
    }
}

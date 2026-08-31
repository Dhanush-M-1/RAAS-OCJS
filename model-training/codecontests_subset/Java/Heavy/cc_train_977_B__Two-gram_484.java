
import java.util.*;

public class TestCodeforces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());

        String s = scanner.nextLine();
        Map<String, Integer> m = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            String s2 = s.substring(i, i + 2);
            m.put(s2, m.getOrDefault(s2, 0) + 1);
        }
        int max = 0;
        for (String s2 : m.keySet()) {
            max = Math.max(max, m.get(s2));
        }

        for (String s2 : m.keySet()) {
            if (m.get(s2) == max) {
                System.out.println(s2);
                scanner.close();
                return;
            }
        }


        scanner.close();
    }
}









import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class kString {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Map<Character, Integer> count = new HashMap<>();
        String str = scanner.next();

        if (k == 1) {
            System.out.println(str);
        } else {
            for (char c : str.toCharArray()) {
                int innerCount = 0;
                if (count.containsKey(c)) {
                    innerCount = count.get(c);
                }
                count.put(c, ++innerCount);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : count.entrySet()) {
                if (entry.getValue() % k != 0) {
                    System.out.println(-1);
                    return;
                }
                for (int i = 0; i < entry.getValue() / k; i++) {
                    stringBuilder.append(entry.getKey());
                }
            }
            for (int i = 0; i < k; i++) {
                System.out.print(stringBuilder.toString());
            }
            System.out.println();
        }

    }
}

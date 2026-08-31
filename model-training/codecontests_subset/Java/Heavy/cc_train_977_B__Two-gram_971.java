import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoGram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        Map<String, Integer> occs = new HashMap<>();
        String max = String.valueOf(s.charAt(0)) + s.charAt(1);
        int maxOccs = 1;
        for (int i = 3; i < s.length(); i++) {
            String curr = String.valueOf(s.charAt(i-1)) + s.charAt(i);
            if (occs.containsKey(curr)) {
                int newNum = occs.get(curr) + 1;
                occs.put(curr, newNum);
                if (newNum > maxOccs) {
                    maxOccs = newNum;
                    max = curr;
                }
            } else {
                occs.put(curr, 1);
            }
        }
        System.out.println(max);
    }
}
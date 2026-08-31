//package Archive;
// 219A
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String str = in.next();

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character letter = str.charAt(i);
            freq.put(letter, freq.getOrDefault(letter, 0) + 1);
        }

        for (Map.Entry<Character, Integer> letter_stat: freq.entrySet()) {
            int occured = letter_stat.getValue();
            if (occured % k != 0) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder result= new StringBuilder();
        for (Map.Entry<Character, Integer> letter_stat: freq.entrySet()) {
            int occured = letter_stat.getValue() / k;
            Character letter = letter_stat.getKey();
            result.append(String.valueOf(letter).repeat(occured));
        }
        result.append(result.toString().repeat(k-1));
        System.out.println(result);
    }
}

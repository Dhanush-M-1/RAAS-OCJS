import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        HashMap<Character, Integer[]> letters = new HashMap<Character, Integer[]>();
        String s = input.next();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters.containsKey(c)) {
                Integer[] pastValue = letters.get(c);
                pastValue[0]++;
                letters.put(c, pastValue);
            } else {
                letters.put(c, new Integer[]{1,0});
            }
        }
        /*
        for (Map.Entry<Character, Integer[]> letter : letters.entrySet()) {
            System.out.println(letter.getKey() + " " + letter.getValue()[0] + " " + letter.getValue()[1]);
        }*/
        boolean can = true;
        for (Map.Entry<Character, Integer[]> letter : letters.entrySet())
            if (letter.getValue()[0] % k != 0) {
                can = false;
                break;
            } else {
                letter.getValue()[1] = letter.getValue()[0] / k;
            }
        if (!can) System.out.println(-1);
        else {
            for (int i = 0; i < k; i++)
                for (Map.Entry<Character, Integer[]> letter : letters.entrySet())
                    for (int l = 0; l < letter.getValue()[1]; l++) System.out.print(letter.getKey());
            System.out.println();
        }
    }

}
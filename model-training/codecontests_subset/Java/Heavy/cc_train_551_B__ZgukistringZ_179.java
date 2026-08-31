import java.util.*;

/**
 * Created by daria on 12.01.15.
 */
public class B {
    Scanner in;

    void run() {
        in = new Scanner(System.in);
        solve();
    }

    int[] letters;

    void solve() {
        String source = in.next();
        String b = in.next();
        String c = in.next();
        int n = source.length();
        StringBuilder result = new StringBuilder();

        letters = new int[26];
        for (int i = 0; i < n; i++) {
            char cur = source.charAt(i);
            letters[cur - 'a']++;
        }


        int[] lettersB = new int[26];
        int[] lettersC = new int[26];
        for (int i = 0; i < b.length(); i++) {
            char cur = b.charAt(i);
            lettersB[cur - 'a']++;
        }
        for (int i = 0; i < c.length(); i++) {
            char cur = c.charAt(i);
            lettersC[cur - 'a']++;
        }



        int quanB = check(lettersB, b);
        int quanC = check(lettersC, c);

        while (quanB > 0 || quanC > 0) {
            if (quanB > quanC) {
                result.append(b);
                for (int i = 0; i < 26; i++) {
                    letters[i] -= lettersB[i];
                }
                quanB--;
                if (quanC > 0) {
                    quanC = check(lettersC, c);
                }

            }
            else {
                result.append(c);
                for (int i = 0; i < 26; i++) {
                    letters[i] -= lettersC[i];
                }
                quanC--;
                if (quanB > 0) {
                    quanB = check(lettersB, b);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < letters[i]; j++) {
                result.append((char) (i + 'a'));
            }
        }


        System.out.println(result.toString());


    }


    int check(int[] usedLetters, String p) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < p.length(); i++) {
            char cur = p.charAt(i);
            result = Math.min(result, letters[cur - 'a'] / usedLetters[cur - 'a']);
            if (result == 0) {
                return 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new B().run();
    }
}
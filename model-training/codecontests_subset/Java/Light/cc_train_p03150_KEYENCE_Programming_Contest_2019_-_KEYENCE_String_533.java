import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            new Main().solve(sc);
        }
    }

    void solve(Scanner sc) {
        char[] s = sc.next().toCharArray();
        char[] key = {'k', 'e', 'y', 'e', 'n', 'c', 'e'};
        
        int preCount = 0;
        for (int i = 0; i < key.length; i++) {
            if (s[i] != key[i]) {
                break;
            }
            preCount++;
        }

        int sufIndex = 0;
        for (int i = 0; i < key.length; i++) {
            if (s[s.length - 1 - i] != key[key.length - 1 - i]) {
                break;
            }
            sufIndex++;
        }

        if (preCount + sufIndex >= key.length) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

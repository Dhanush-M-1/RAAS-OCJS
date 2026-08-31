import java.util.*;
import java.math.*;

public class Main {
    static final long MOD = 1000000007L;
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int[] count = new int[26];
        int K = scan.nextInt();
        scan.nextLine();
        char[] arr = scan.nextLine().toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] % K != 0) {
                System.out.println(-1);
                return;
            }
            char c = (char)('a' + i);
            for (int j = 0; j < count[i] / K; j++) {
                builder.append(c);
            }
        }
        String str = builder.toString();
        for (int i = 0; i < K; i++) {
            System.out.print(str);
        }
        System.out.println();
    }
}
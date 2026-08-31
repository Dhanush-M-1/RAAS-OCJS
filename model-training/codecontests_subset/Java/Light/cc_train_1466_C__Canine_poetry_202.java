import java.util.Scanner;

public class Palindrom {
    private void palindrom(Scanner in) {
        int ans = 0;
        String str = in.next();
        char[] s = str.toCharArray();
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] == s[i] || i - 2 >= 0 && s[i - 2] == s[i]) {
                ans++;
                s[i] = '_';
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Palindrom palindrom = new Palindrom();
        // PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            palindrom.palindrom(in);
        }
    }
}

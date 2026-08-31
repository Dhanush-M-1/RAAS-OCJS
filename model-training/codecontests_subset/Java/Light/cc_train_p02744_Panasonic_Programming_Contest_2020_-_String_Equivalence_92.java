import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        f("a", "abcdefghij", "a", n);

    }

    static void f(String s, String canUse, String used, int n) {
        if (s.length() == n) {
            System.out.println(s);
            return;
        }

        int i = 0;
        for (i = 0; i < used.length(); i++) {
            String newS = s + used.charAt(i);
            f(newS, canUse, used, n);
        }
        String newS = s + canUse.charAt(i);
        f(newS, canUse, used + canUse.charAt(i), n);

        return;
    }
}

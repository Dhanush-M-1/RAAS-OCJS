import java.util.Scanner;

public class A868 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String password = in.next();
        boolean found = false;
        boolean endsWithStart = false;
        boolean startsWithEnd = false;
        int N = in.nextInt();
        for (int n=0; n<N; n++) {
            String s = in.next();
            if (password.equals(s)) {
                found = true;
            }
            if (s.charAt(1) == password.charAt(0)) {
                endsWithStart = true;
            }
            if (s.charAt(0) == password.charAt(1)) {
                startsWithEnd = true;
            }
        }
        boolean ok = found || (endsWithStart && startsWithEnd);
        System.out.println(ok ? "YES" : "NO");
    }

}

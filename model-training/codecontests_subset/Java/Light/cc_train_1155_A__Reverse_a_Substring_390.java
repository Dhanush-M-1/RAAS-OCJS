import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        PrintWriter cout = new PrintWriter(System.out);
        int N = Integer.parseInt(cin.nextLine());
        String in = cin.nextLine();
        int l = 0;
        boolean fnd = false;
        for (; l < N - 1; ++l) {
            if (in.charAt(l) > in.charAt(l + 1)) {
                fnd = true;
                break;
            }
        }
        cout.println(fnd ? "YES" : "NO");
        if (fnd) {
            cout.println((l + 1) + " " + (l + 2));
            //cout.println(in.substring(0, l) + new StringBuilder(in.substring(l, l + 2)).reverse().toString() + in.substring(l + 2));
        }
        cout.flush();
    }
}

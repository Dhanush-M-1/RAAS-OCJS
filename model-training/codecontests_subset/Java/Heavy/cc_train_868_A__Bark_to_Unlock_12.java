
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] c = in.next().toCharArray();
        byte n = in.nextByte();
        char ch[][] = new char[n][2];
        boolean b = false, bool = false;
        for (byte i = 0; i < n; i++) {
            ch[i] = in.next().toCharArray();
            if (ch[i][1] == c[0] || (ch[i][0] == c[0] && ch[i][1] == c[1])) {
                b = true;
            }
        }
        for (byte i = 0; i < n; i++) {
            if (ch[i][0] == c[1] || (ch[i][0] == c[0] && ch[i][1] == c[1])) {
                bool = true;
            }
        }
        System.out.println((b && bool) ? "YES" : "NO");
    }
}

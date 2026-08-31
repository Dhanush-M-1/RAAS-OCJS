import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class B174 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = in.nextInt();
        String s = in.next();
        int f = 0;
        int a = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            switch (s.charAt(j)) {
                case 'A':
                    a++;
                    break;
                case 'I':
                    i++;
                    break;
                case 'F':
                    f++;
                    break;
            }
        }
        if (i == 0) {
            out.print(a);
        } else if (i == 1) {
            out.print("1");
        } else {
            out.print("0");
        }
        out.close();
    }
}

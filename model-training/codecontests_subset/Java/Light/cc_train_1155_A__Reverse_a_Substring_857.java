import java.io.*;
import java.io.PrintStream;
import java.util.*;


public class Main{

    Scanner in = new Scanner(System.in);
    PrintStream out = new PrintStream(System.out);
    int n;
    String s;


    public void main() {
        n = in.nextInt();
        s = in.next();
        boolean f = true;
        for(int i = 0; i < n; ++i) {
            if (i+1 < n && s.charAt(i) > s.charAt(i+1)) {
                out.println("YES");
                out.print(i + 1 + " " + (i + 2));
                f = false;
                break;
            }
        }
        if (f) out.print("NO");
    }


    public static void main(String[] $) throws IOException {
        new Main().main();
    }

}

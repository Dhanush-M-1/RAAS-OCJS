import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class P114A {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintStream out = System.out;
        //CODING TAIM

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        out.println(Math.max(0, (int)Math.ceil(n*(double)y/100.0) - x));
    }

}

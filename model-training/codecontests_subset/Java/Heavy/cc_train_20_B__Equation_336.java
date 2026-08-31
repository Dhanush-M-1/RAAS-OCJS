import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
//import java.lang.StringBuilder;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.ArrayList;

public class Equation {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st1 = new StringTokenizer(in.readLine());
        long a = Integer.parseInt(st1.nextToken());
        long b = Integer.parseInt(st1.nextToken());
        long c = Integer.parseInt(st1.nextToken());
        if(a == 0 && b == 0 && c == 0) {
            out.print(-1);
            out.close();
            return;
        }
        if(a == 0 && b != 0) {
            out.println(1);
            double x = - (double) c / (double) b;
            out.print(x);
            out.close();
            return;
        }
        if(a == 0 && b == 0) {
            out.println(0);
            out.close();
            return;
        }
        long delta = (long)Math.round(Math.pow(b, 2)) - (4*a*c);
        if(delta < 0) {
            out.print(0);
            out.close();
            return;
        } else if(delta == 0) {
            out.println(1);
            double x = (double) -b / (2.0 * (double)a);
            out.print(x);
            out.close();
            return;
        }
        out.println(2);
        double x1 = ((double)-b + Math.sqrt(delta)) / (2.0 * (double)a);
        double x2 = ((double)-b - Math.sqrt(delta)) / (2.0 * (double)a);
        if(x1 < x2) {
            out.println(x1);
            out.println(x2);
        } else {
            out.println(x2);
            out.println(x1);
        }
        out.close();
    }
}
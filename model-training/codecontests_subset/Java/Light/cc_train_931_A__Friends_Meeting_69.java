import java.io.*;
import java.util.*;

public class problemA {

    public void solve(Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int diff = Math.abs(a - b);
        if (diff % 2 == 0) {
            diff /= 2;
            out.println((1 + diff) * diff);
        } else {
            diff /= 2;
            out.println((1 + diff) * diff + diff + 1);
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        new problemA().solve(in, out);

        in.close();
        out.close();
    }

}

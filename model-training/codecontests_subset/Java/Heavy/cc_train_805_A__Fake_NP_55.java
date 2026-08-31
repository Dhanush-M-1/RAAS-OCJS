import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

public class dd {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TASK solver = new TASK();
        solver.solve(1, in, out);
        out.close();
    }

    static class TASK {
        public void solve(int test_N , Scanner in , PrintWriter out) {
            int l = in.nextInt();
            int r = in.nextInt();
            if(l == r)
                out.print(l);
            else
                out.print(2);
        }
    }
}


import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int n;

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        Input(new Scanner(System.in), pw);
        pw.flush();
        pw.close();
    }

    public static void Input(Scanner input, PrintWriter pw) {
        n = input.nextInt();
        int[] a;
        int[] b;
        int[] c;
        boolean b1 = false, b2 = false;

        StringBuilder builder = new StringBuilder();

        a = IntStream.range(0, n).map(i -> input.nextInt()).toArray();
        b = IntStream.range(0, n - 1).map(i -> input.nextInt()).toArray();
        c = IntStream.range(0, n - 2).map(i -> input.nextInt()).toArray();

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        for (int i = 0; i < n - 1; ++i) {
            if (a[i] != b[i]) {
                b1 = true;
                builder.append(a[i]).append("\n");
                break;
            }
        }
        if (!b1) builder.append(a[n - 1]).append("\n");

        for (int i = 0; i < n - 2; ++i) {
            if (b[i] != c[i]) {
                b2 = true;
                builder.append(b[i]).append("\n");
                break;
            }
        }
        if (!b2) builder.append(b[n - 2]).append("\n");


        pw.println(builder.toString());

    }

}



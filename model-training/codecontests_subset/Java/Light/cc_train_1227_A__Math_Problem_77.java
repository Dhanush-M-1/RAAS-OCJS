import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ринат on 26.09.2018.
 */
public class B {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        for (int i = 0; i <n; i++) {
            int m = in.nextInt();
            int[]a = new int[m];
            int[]b = new int[m];
            for (int j = 0; j <m ; j++) {
                a[j] = in.nextInt();
                b[j] = in.nextInt();
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int x = a[m-1]-b[0];
            if(x<0)x=0;
            out.println(x);
        }
        out.close();
    }
}
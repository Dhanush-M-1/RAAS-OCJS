
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {

    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();

        ArrayList<Integer> a = new ArrayList<>();

        for (int i=0;i<n;i++) {
            a.add(in.nextInt());
        }

        Collections.sort(a);
        boolean arr[] = new boolean[n];

        for (int i=0;i<n-1;i++)
        {
            if (a.get(i+1)>a.get(i) && a.get(i+1)<=(a.get(i)+k))    arr[i] = true;
        }

        int count=1;
        int llimit = a.get(n-1)-k;
        int ulimit = a.get(n-1)-1;

        for (int i=n-2;i>=0;i--)
        {
            int x = a.get(i);
            if (x>=llimit && x<=ulimit)
            {
                ulimit = x;
                llimit = x-k;
            }
            else
            {
                count++;
                llimit = x-k;
                ulimit = x-1;
            }
        }

        System.out.println(count);
    }
}
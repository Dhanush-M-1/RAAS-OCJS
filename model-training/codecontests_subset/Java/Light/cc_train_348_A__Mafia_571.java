import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Timur on 15.12.2016.
 */
public class _348A {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long n = in.nextLong();
        long sum = 0;
        long max = 0;
        for(int i = 0; i < n; i++){
            long numb = in.nextLong();
            sum += numb;
            max = Math.max(max, numb);
        }
        long ans = (sum + n - 2) / (n - 1);
        if(ans < max)
            ans = max;
        out.print(ans);
        out.close();
    }
}

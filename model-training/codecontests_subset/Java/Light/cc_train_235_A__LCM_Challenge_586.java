import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Timur on 02.12.2016.
 */
public class _235C {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long N = in.nextLong();
        if(N == 1) out.print(1);
        else if(N == 2) out.print(2);
        else{
            if((N & 1) == 1)
                out.print(N * (N - 1) * (N - 2));
            else{
                if(N % 3 == 0)
                    out.print((N - 1) * (N - 2) * (N - 3));
                else
                    out.print(N * (N - 1) * (N - 3));
            }
        }
        out.close();
    }
}

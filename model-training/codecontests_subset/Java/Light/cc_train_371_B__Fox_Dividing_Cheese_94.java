import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Timur on 14.12.2016.
 */
public class _371B_radical {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int a = in.nextInt();
        int b = in.nextInt();
        int x[] = new int[6];
        int y[] = new int[6];

        solve(a, x);
        solve(b, y);

        out.print(x[0] != y[0] ? -1 : Math.abs(x[2] - y[2]) + Math.abs(x[3] - y[3]) +Math.abs(x[5] - y[5]));
        out.close();
    }

    public static void solve(int x, int counting[]){
        while(x > 0 && x % 2 == 0){
            x /= 2;
            counting[2]++;
        }
        while(x > 0 && x % 3 == 0){
            x /= 3;
            counting[3]++;
        }
        while(x > 0 && x % 5 == 0){
            x /= 5;
            counting[5]++;
        }
        counting[0] = x;
    }
}

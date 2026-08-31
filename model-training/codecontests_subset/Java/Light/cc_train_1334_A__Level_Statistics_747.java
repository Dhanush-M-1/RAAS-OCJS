import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream pw = new PrintStream(System.out);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int p = 0, c = 0;
            boolean fl = true;
            for(int i = 0;i<n; i++){
                int x=in.nextInt(), y=in.nextInt();
                if (x < p || y < c || y - c > x - p)
                    fl = false;
                p = x;
                c = y;
            }
            pw.println(fl ? "YES" : "NO");
        }
    }
}
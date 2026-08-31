import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by fatminmin on 5/8/16.
 */
public class PD {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    public void run() {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] id = new int[n];
        id[0] = sc.nextInt();
        id[n - 1] = sc.nextInt();
        id[1] = sc.nextInt();
        id[3] = sc.nextInt();
        int idx = 1;
        for(int i = 2; i < n - 1; i++) {
            if(i == 3) continue;
            while(idx == id[0] || idx == id[1] || idx == id[3] || idx == id[n - 1]) idx++;
            id[i] = idx++;
        }
        if(n == 4) {
            pw.println(-1);
        } else {
            if(k < n + 1) {
                pw.println(-1);
            } else {
                for(int i = 0; i < n; i++) {
                    if(i > 0) pw.print(" ");
                    pw.print(id[i]);
                }
                pw.println("");
                pw.print(id[1] + " " + id[0] + " " + id[2] + " " + id[n - 1]);
                for(int i = n - 2; i >= 3; i--) {
                    pw.print(" " + id[i]);
                }
                pw.println("");
            }
        }
        pw.flush();
    }

    public static void main(String[] args) {
        new PD().run();
    }
}

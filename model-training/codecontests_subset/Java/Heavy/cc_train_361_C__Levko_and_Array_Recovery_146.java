import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        int m=in.nextInt();
        int[] t=new int[m];
        int[] l=new int[m];
        int[] r=new int[m];
        int[] d=new int[m];
        int[] delta=new int[n];
        int[] bound=new int[n];
        Arrays.fill(bound, 1000000000);
        for (int i = 0; i < m; i++) {
            t[i]=in.nextInt();
            l[i]=in.nextInt();
            r[i]=in.nextInt();
            d[i]=in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            if (t[i]==1){
                for (int j = l[i]-1; j < r[i]; j++) {
                    delta[j]+=d[i];
                }
            }
            else{
                for (int j = l[i] - 1; j < r[i]; j++) {
                    bound[j]=Math.min(bound[j],d[i]-delta[j]);
                }
                }
        }
        Arrays.fill(delta,0);
        boolean ok=true;
        for (int i = 0; i < m; i++) {
            if (t[i]==1){
                for (int j = l[i] - 1; j < r[i]; j++) {
                    delta[j]+=d[i];
                }
            }
            else{
                int max=-1000000000;
                for (int j = l[i] - 1; j < r[i]; j++) {
                    max=Math.max(max,bound[j]+delta[j]);
                }
                if (max!=d[i]) {
                    ok=false;
                    break;
                }
            }
        }
        if (ok){
            out.println("YES");
            for (int i = 0; i < n; i++) {
                out.print(bound[i]+" ");
            }
        }
        else{
            out.println("NO");
        }
    }
}


import java.util.Arrays;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author mengshangqi
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Cf500C solver = new Cf500C();
		solver.solve(1, in, out);
		out.close();
	}
}

class Cf500C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        int m=in.nextInt();

        int[] w=new int[n];
        int[] id=new int[m];
        for(int i=0;i<n;i++) w[i]=in.nextInt();
        for(int j=0;j<m;j++) id[j]=in.nextInt()-1;
        boolean[] vis=new boolean[n];
        int res=0;
        for(int i=1;i<m;i++) {
            Arrays.fill(vis,false);
            int sum=0;
            for(int j=i-1;j>=0;j--) {
                if(id[j]==id[i]) break;
                if(vis[id[j]]) continue;
                sum+=w[id[j]];
                vis[id[j]]=true;
            }
            res+=sum;
        }
        out.println(res);
    }
}


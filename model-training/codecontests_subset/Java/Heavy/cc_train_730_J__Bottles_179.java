import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class A {

    void solve() throws IOException {
        int n = nI();
        int [] a = new int [n];
        int [] b = new int [n];
        int z = 0;
        int s = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nI();
            z += a[i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = nI();
            s += b[i];
        }
        s++;
        int [][]ar = new int [n+1][s];
        int [][]ar2 = new int [n+1][s];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(ar[i], -1);
        }
        ar[0][0] = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < s; j++) {
                if (j==0) {
                    ar[i][j] = 0;
                }
                else if (j-b[i-1]>=0){
                    int qqq = ar[i-1][j-b[i-1]]+1;
                    int lll = ar[i-1][j];
                    if(qqq>0 && lll >=0 && qqq>lll){
                        ar[i][j] = lll;
                        ar2[i][j] = ar2[i - 1][j];
                    }else if(qqq>0 && lll >=0 && qqq<lll){
                        ar[i][j] = qqq;
                        ar2[i][j] = ar2[i-1][j-b[i-1]] + a[i-1];
                    }
                    else if(qqq>0 && lll >=0){
                        ar[i][j] = qqq;
                        ar2[i][j] = Math.max(ar2[i - 1][j],ar2[i-1][j-b[i-1]] + a[i-1]);
                    }
                    else if(qqq>0){
                        ar[i][j] = qqq;
                        ar2[i][j] = ar2[i-1][j-b[i-1]] + a[i-1];
                    }
                    else if(lll>=0){
                        ar[i][j] = lll;
                        ar2[i][j] = ar2[i - 1][j];
                    }
                }
                else {
                    if(ar[i-1][j]>=0){
                        ar[i][j] = ar[i-1][j];
                        ar2[i][j] = ar2[i-1][j];
                    }
                }

            }
        }
        int a1 = Integer.MAX_VALUE;
        int a2 = -1;
        for (int i = z; i < s; i++) {
            if (ar[n][i]>=0&&a1>ar[n][i]){
                a1 = ar[n][i];
                a2 = ar2[n][i];
            }
            else if(ar[n][i]>=0&&a1==ar[n][i]){
                a2 = Math.max(a2,ar2[n][i]);
            }
        }
        out.println(a1 + " " + (z-a2));
    }

    public static void main(String [] args) throws IOException {
        (new A()).run();
    }
    StreamTokenizer in;
    PrintWriter out;
    void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();
    }
    int nI() throws IOException {
        in.nextToken();
        return (int)in.nval;
    }
    String nS() throws IOException {
        in.nextToken();
        return in.sval;
    }
}

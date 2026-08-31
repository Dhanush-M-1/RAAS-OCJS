
import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by sbabkin on 9/14/2015.
 */
public class SolverE {

    public static void main(String[] args) throws IOException {
        new SolverE().Run();
    }

    BufferedReader br;
    PrintWriter pw;
    StringTokenizer stok;

    private String nextToken() throws IOException {
        while (stok==null || !stok.hasMoreTokens()){
            stok = new StringTokenizer(br.readLine());
        }
        return stok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    final double eps = 1e-11;
    int n;
    int[] mas;
    double maxSum;
    double minSum;

    private void Run() throws IOException {
//        br=new BufferedReader(new FileReader("input.txt"));
//        pw=new PrintWriter("output.txt");
        br=new BufferedReader(new InputStreamReader(System.in));
        pw=new PrintWriter(new OutputStreamWriter(System.out));

        n=nextInt();
        mas=new int[n];
        for (int i=0; i<n; i++) {
            mas[i]=nextInt();
        }

        double max=11000;
        double min=-11000;
        while (max-min>eps){
            double mid=(max+min)/2;
            calcExtrems(mid);
            if (maxSum>-minSum){
                min=mid;
            } else {
                max=mid;
            }
        }
        calcExtrems((max+min)/2);
        pw.println(Math.max(maxSum, -minSum));
        pw.flush();
        pw.close();
    }

    private void calcExtrems(double mid) {
        maxSum=0;
        minSum=0;
        double curMax=0;
        double curMin=0;
        for (int i=0; i<n; i++) {
            curMax+=(mas[i]-mid);
            curMin+=(mas[i]-mid);
            if (curMax<0){
                curMax=0;
            }
            if (curMin>0){
                curMin=0;
            }
            maxSum=Math.max(maxSum, curMax);
            minSum=Math.min(minSum, curMin);
        }
    }

}

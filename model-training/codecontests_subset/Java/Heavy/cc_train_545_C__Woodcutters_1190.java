/* Harish Anumula  */
import java.util.*;
//import java.awt.Point;
import java.io.*;
//import java.math.BigInteger;

public class MAXEINSTLE
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        FastScanner scan = new FastScanner(br);
        Task solver = new Task();
        solver.solve(scan,pw);
        pw.close();
    }
}



class Task{
    //long MOD = (long)1e9+7L;
    public void solve(FastScanner scan , PrintWriter pw) throws java.lang.Exception{
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0;i<n;i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        long c = Math.min(2,n);
        for(int i = 1;i<n-1;i++){
            if(arr[i][0]-arr[i-1][0]>arr[i][1]){
                c++;
            }
            else if(arr[i+1][0]-arr[i][0]>arr[i][1]){
                c++;
                arr[i][0] += arr[i][1];
            }
        }
        pw.println(c);
    }
}


class FastScanner {

    BufferedReader br;
    StringTokenizer st;

    public FastScanner(BufferedReader br) {
        this.br = br;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
    public String nextLine() throws Exception {
        return br.readLine();
    }
}
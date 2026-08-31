import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task893D {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        Task893D task = new Task893D();
        task.open();
        task.solve();
        task.close();
    }

    private void close() {
        out.close();
    }

    private void solve() throws IOException {
        int n = nextInt();
        int d = nextInt();
        int low=0;
        int high=0;
        int ai=0;
        int count=0;
        boolean judge=true;
        for(int i=0;i<n;i++){
            ai=nextInt();
            if(ai==0){
                if(high<0){
                    high=d;
                    count++;
                }
                low=Math.max(0,low);
            }else{
                low+=ai;
                high+=ai;
                high=Math.min(high,d);
                if(low>d){
                    judge=false;
                    i=n;
                }
            }
        }
        if(!judge){
            out.println(-1);
        }else{
            out.println(count);
        }


    }

    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
}

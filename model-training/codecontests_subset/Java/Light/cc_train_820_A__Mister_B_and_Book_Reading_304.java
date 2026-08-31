import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int c = in.nextInt();
        int v0 = in.nextInt();
        int v1 = in.nextInt();
        int a = in.nextInt();
        int l = in.nextInt();
        int sum = v0;
        int count=1;
        v0+=a;
        while(sum<c){
            if(v0+l<=v1){
               sum+=v0-l; 
            }else{
                sum+= Math.min(v0, v1)-l;
            }
            v0+=a;
            count++;
        }
        System.out.println(count);
       
                }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

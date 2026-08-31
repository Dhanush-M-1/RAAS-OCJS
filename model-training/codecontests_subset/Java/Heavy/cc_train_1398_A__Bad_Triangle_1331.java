import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int T=0;T<t;T++) {
            int n = Integer.parseInt(in.readLine());
            String[] inp = in.readLine().split("\\s+");
            long[] arr = new long[n];
            for(int i=0;i<arr.length;i++)
                arr[i] =  Long.parseLong(inp[i]);
            if(arr[0]+arr[1]<=arr[n-1])
                System.out.println("1 2 "+n);
            else
                System.out.println(-1);
        }
    }
}
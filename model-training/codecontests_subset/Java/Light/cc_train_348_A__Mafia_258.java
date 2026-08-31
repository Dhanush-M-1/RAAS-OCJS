import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Mafia {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        int arr[] = new int [n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        long res = 0;
        long max = 0;
        long sum = 0;
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum+= arr[i];
        }
        res = Math.max(max, ((sum-1)/(n-1))+1);
        out.println(res);
        in.close();
        out.close();
    }

}

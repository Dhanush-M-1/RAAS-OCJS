import java.util.*;
import java.io.*;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum1 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int b = Integer.parseInt(st.nextToken());
            sum1+=b;
        }
        st = new StringTokenizer(br.readLine());
        long sum2 = 0;
        for(int i=0;i<n-1;i++){
            int b = Integer.parseInt(st.nextToken());
            sum2+=b;
        }
        st = new StringTokenizer(br.readLine());
        long sum3 = 0;
        for(int i=0;i<n-2;i++){
            int b = Integer.parseInt(st.nextToken());
            sum3+=b;
        }
        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
    }
}
import java.io.*;
import java.util.*;
 
public class G {
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(file.readLine());
        int max = (int)1e7;
        int[] d = new int[max+1];
        int[] ans = new int[max+1];
        Arrays.fill(ans, -1);
        for (int i=1; i<=max; i++){
            for (int j=i; j<=max; j += i){
                // Add myself as the divsor of the multiples of me
                d[j] += i;
            }
            if (d[i] <= max && ans[d[i]] == -1){
                ans[d[i]] = i;
            }
        }
        for (int q=0; q<t; q++){
            int c = Integer.parseInt(file.readLine());
            System.out.println(ans[c]);
        }
    }
}
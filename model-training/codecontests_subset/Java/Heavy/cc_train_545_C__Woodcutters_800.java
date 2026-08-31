import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS545C_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] h = new int[n];

        String[] col = null;
        for(int i=0; i<n; i++) {
            col = br.readLine().split("\\s");
            x[i] = Integer.parseInt(col[0]);
            h[i] = Integer.parseInt(col[1]);
        }

        int count = 1;
        for(int i=1; i<n-1; i++) {
            if(x[i] - x[i-1] > h[i]) {
                count++;
            }
            else if(x[i+1] - x[i] > h[i]) {
                count++;
                x[i] = x[i] + h[i];
            }
        }

        if(n == 1)
            System.out.println(1);
        else {
            count++;
            System.out.println(count);
        }
    }
}
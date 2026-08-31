import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BadTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(bf.readLine());
        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            long arr[]= new long[n];
            for (int j = 0; j < n; j++) {
                arr[j]=Integer.parseInt(st.nextToken());
            }
            if (arr[0]+arr[1]<=arr[n-1])
                System.out.println("1 2 "+n);
            else
                System.out.println(-1);
        }
    }
}

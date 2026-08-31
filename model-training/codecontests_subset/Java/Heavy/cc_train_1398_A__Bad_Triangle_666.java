import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            int a1 = Integer.parseInt(arr[0]);
            int a2 = Integer.parseInt(arr[1]);
            int a3 = Integer.parseInt(arr[n-1]);

            if(!(a1+a2>a3))
            {
                System.out.println("1 2 "+ (n));
            }
            else
            {
                System.out.println(-1);
            }

        }
    }
}
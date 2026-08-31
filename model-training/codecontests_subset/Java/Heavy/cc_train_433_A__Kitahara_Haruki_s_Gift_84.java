import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task_433A {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] a = new int[n];
        int temp = 0;
        boolean b = false;
        
        for (int i = 0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            temp += a[i];
            if (a[i] == 100) {
                b = true;
            }
        }
        
        if (temp % 200 == 50) {
            System.out.println("NO");
        } else if (temp % 200 == 0 && n % 2 != 0 && b == true) {
            System.out.println("YES");
        } else if (temp % 200 == 0 && n % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

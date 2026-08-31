import java.io.PrintWriter;
import java.util.*;

public class Main {

    Scanner sc = new Scanner(System.in);

    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();

        int cnt = 0;

        for (int i=0; i<n-1; i++) {
            if (arr[i]==i+1) {
                cnt++;
                int tmp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = tmp;
            }
        }

        if (arr[n-1]==n) cnt++;

        System.out.println(cnt);

    }
}
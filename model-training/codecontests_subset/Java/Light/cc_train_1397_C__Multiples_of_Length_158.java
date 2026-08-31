import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(1 + " " + 1);
        System.out.println(-arr[0]);
        if (n == 1) {
            System.out.println(1 + " " + 1);
            System.out.println(0);
            System.out.println(1 + " " + 1);
            System.out.println(0);
        } else {
            System.out.println(1 + " " + n);
            System.out.print(0 + " ");
            for (int i = 1; i < n; i++)
                System.out.print(-(long) n * arr[i] + " ");
            System.out.println();

            System.out.println(2 + " " + n);
            for (int i = 1; i < n; i++)
                System.out.print((long) (n - 1) * arr[i] + " ");
            System.out.println();
        }
    }
}

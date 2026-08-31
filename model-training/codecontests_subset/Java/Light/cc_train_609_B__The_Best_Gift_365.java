import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] g = new int[m];

        for (int i = 0; i < n; i++)
            g[in.nextInt()-1]++;

        int res = 0;

        for (int i = 0; i < m; i++) {

            for (int j = i+1; j < m; j++) {
                res += g[i]*g[j];
            }

        }

        System.out.println(res);
    }
}

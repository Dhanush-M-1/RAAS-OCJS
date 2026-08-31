import java.io.*;
import java.util.*;

public class subsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int t = Integer.parseInt(st.nextToken());
        for (int e = 1; e <= t; e++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[n1];
            int[] arr2 = new int[n2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n1; i++)
                arr1[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n2; i++)
                arr2[i] = Integer.parseInt(st.nextToken());
            int ans = -1;
            outer:
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n2; j++) {
                    if (arr1[i] == arr2[j]) {
                        ans = arr1[i];
                        break outer;
                    }
                }
            }
            if (ans == -1)
                System.out.println("NO");
            else {
                System.out.println("YES");
                System.out.println("1 " + ans);
            }
        }
    }
}
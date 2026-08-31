import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ary1 = new int[n][2];
        for (int i = 0; i < n; i++) {
            ary1[i][0] = sc.nextInt();
            ary1[i][1] = sc.nextInt();
        }
        int[][] ary2 = new int[m][2];
        for (int i = 0; i < m; i++) {
            ary2[i][0] = sc.nextInt();
            ary2[i][1] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            int ans = -1;
            int min = 1000000000;
            for (int j = 0; j < m; j++) {
                int tmp = (int)Math.abs(ary1[i][0] - ary2[j][0]) + Math.abs(ary1[i][1] - ary2[j][1]);
                if (tmp < min) {
                    min = tmp;
                    ans = j;
                }
            }
            System.out.println(ans+1);
        }
    }
}

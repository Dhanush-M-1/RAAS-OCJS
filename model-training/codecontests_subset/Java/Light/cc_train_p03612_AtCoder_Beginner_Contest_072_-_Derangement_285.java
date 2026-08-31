import java.util.*;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] p = new int[N + 1];
        for (int i = 1; i < p.length; i++) {
            p[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 1; i < p.length; i++) {
            if (i == p[i]){
                cnt++;
                if(i < p.length - 1) {
                    int tmp = p[i];
                    p[i] = p[i + 1];
                    p[i + 1] = tmp;
                }
            }
        }

        out.println(cnt);
    }
}
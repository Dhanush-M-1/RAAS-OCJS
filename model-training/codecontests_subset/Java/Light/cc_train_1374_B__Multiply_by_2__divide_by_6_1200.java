

import java.util.*;

public class CodeforcesContest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nExperiments = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < nExperiments; i++) {
            int n = sc.nextInt();
            int ans = sport(n);
            System.out.println(ans);
        }
    }

    private static int sport(int n) {
        int n2 = 0;
        int n3 = 0;
        while (n % 2 == 0) {
            n /= 2;
            n2++;
        }
        while (n % 3 == 0) {
            n /= 3;
            n3++;
        }
        if (n != 1 || n2 > n3) {
            return -1;
        }
        int ans = (n3 - n2) + n3;
        return ans;
    }
}
import java.util.*;

public class CF550_Div3_B {
    //Parity Alternated Deletions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(sln(A));
        sc.close();
    }

    static int sln(int[] A) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int a : A) {
            if (a % 2 == 0) even.add(a);
            else odd.add(a);
        }
        Collections.sort(even);
        Collections.sort(odd);
        int res = 0, m = odd.size(), n = even.size();
        if (Math.abs(m - n) == 1) return res;
        if (m > n) {
            for (int i = 0; i < m - n - 1; i++) res += odd.get(i);
        } else if (m < n) {
            for (int i = 0; i < n - m - 1; i++) res += even.get(i);
        }
        return res;
    }
}

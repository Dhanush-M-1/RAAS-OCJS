
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt() - 1;
        int[] F = new int[n];
        int[] B = new int[n];
        Arrays.fill(B, -1);
        for (int i = 0; i < n; i++) {
            int y = in.nextInt() - 1;
            F[i] = y;
            if (y != -1)
                B[y] = i;
        }
        LinkedList<Integer> E = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            if (F[i] == -1) {
                int temp = i;
                boolean found = false;
                int cnt = 0;
                while (temp != -1) {
                    cnt++;
                    found |= temp == x;
                    temp = B[temp];
                }
                if (!found)
                    E.add(cnt);
            }
        int front = 0;
        while (x != -1) {
            x = F[x];
            front++;
        }
        boolean[] can = new boolean[n + 1];
        can[0] = true;
        for (int y : E)
            for (int i = n; i >= 0; i--)
                if (i + y <= n)
                    can[i + y] |= can[i];
        for (int i = 0; i <= n; i++)
            if (can[i])
                System.out.println(front + i);
    }
}

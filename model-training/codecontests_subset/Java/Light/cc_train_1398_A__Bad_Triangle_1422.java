import java.util.*;

public final class codeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] ar = new int[n];
            for (int i=0; i<n; i++)
                ar[i] = sc.nextInt();
            if (ar[0]+ar[1]<=ar[n-1])
                res.append(1).append(" ").append(2).append(" ").append(n);
            else res.append(-1);
            res.append("\n");
        }
        System.out.println(res);
        sc.close();
    }
}

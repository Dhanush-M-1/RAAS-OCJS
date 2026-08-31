import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] bool = new boolean[n+1];
        for (int i=0;i<=n;i++){
            bool[i]=true;
        }
        for (int i=0;i<m;i++){
            bool[scanner.nextInt()]=false;
        }
        int[] b = new int[n+1];
        b[0] = 1;
        b[1] = 1;
        int mod = 1000000007;
        for (int i=2;i<=n;i++){
            b[i] = 0;
            if (bool[i-2])b[i]+=b[i-2];
            if (bool[i-1])b[i]+=b[i-1];
            b[i] %= mod;

        }
        System.out.println(b[n]);
    }
}
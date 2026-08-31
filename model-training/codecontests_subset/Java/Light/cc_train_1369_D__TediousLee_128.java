import java.util.Scanner;

public class Main {
    
    static final long MOD = 1000000007;
    
    public static void main(String[] args) {
    
        var sc = new Scanner(System.in);
    
        var a = new long[2000001];
        a[1] = 1;
        a[2] = 1;
        for(int i = 3; i <= 2000000; i++){
            a[i] = a[i-2]*2 + a[i-1];
            a[i] %= MOD;
        }
        var b = new long[2000001];
        b[1] = 0;
        b[2] = 0;
        b[3] = 4;
        b[4] = 4;
        b[5] = 12;
        for(int i = 6; i <= 2000000; i++){
            b[i] = b[i-3] + a[i-2]*4;
            b[i] %= MOD;
        }
        
        int T = Integer.parseInt(sc.next());
        var sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(sc.next());
            sb.append(b[n]).append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
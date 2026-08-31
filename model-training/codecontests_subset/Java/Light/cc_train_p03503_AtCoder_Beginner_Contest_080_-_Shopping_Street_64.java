import java.util.*;
class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] f = new int[n][10];
        int[][] p = new int[n][11];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < 10; j++)
                f[i][j] = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < 11; j++)
                p[i][j] = sc.nextInt();
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < Math.pow(2, 10); i++){
            int tmp = 0;
            String s = pow2(i);
            for(int j = 0; j < n; j++){
                tmp += p[j][cover(s, f[j])];
            }
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }
    static String pow2(int n){
        String res = "";
        for(int i = 1; i <= 10; i++){
            int t = n % 2;
            res += t;
            n /= 2;
        }
        return res;
    }
    static int cover(String s, int[] f){
        int res = 0;
        for(int i  = 0; i < 10; i++){
            String x = Character.toString(s.charAt(i));
            String y = Integer.toString(f[i]);
            if(x.compareTo(y) == 0 && x.compareTo("1") == 0){
                res++;
            }
        }
        return res;
    }
}
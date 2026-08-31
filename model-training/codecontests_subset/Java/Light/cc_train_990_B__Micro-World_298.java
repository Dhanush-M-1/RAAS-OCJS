import java.util.Scanner;
public class Test8   {
    public static void main(String[] Args)   {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] cnt = new int[1000001];
        int[] s = new int[n];
        for (int i = 0; i < n; i++)   {
            s[i] = sc.nextInt();
            cnt[s[i]]++;
        }    
        int n1 = 0;
        int n2 = 0;
        int ct = 0;
        int sum = 0;
        for (int i = 1; i <= k; i++)   {
            sum += cnt[i];
        }    
        for (int i = 0; i <= 999999; i++)   {
            if (sum == 0 ) ct += cnt[i];
            sum -= cnt[i + 1];
            if (k + i + 1<= 1000000) sum += cnt[k + i + 1];
        }    
        System.out.println(ct + cnt[1000000]);
    }    
}    
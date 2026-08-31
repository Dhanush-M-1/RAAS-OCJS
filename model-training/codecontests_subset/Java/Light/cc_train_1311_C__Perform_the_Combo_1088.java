import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        while (T-->0)
        {
            int S = sc.nextInt();
            int M = sc.nextInt();
            String s = sc.next();
            long[] range = new long[s.length()+1];
            for(int i = 0 ; i < M ; i++)
            {
                int end = sc.nextInt();
                range[end]--;
                range[0]++;
            }
            for(int i = 1 ; i< range.length; i++)
            {
                range[i] = range[i-1]+range[i];
            }
            for(int i = 0 ; i < range.length;i++)
                range[i]++;
            StringBuilder sb =new StringBuilder();
            long[] frq = new long[26];
            for(int i  = 0 ; i < S ;i++)
            {
                frq[s.charAt(i)-'a'] += range[i];
            }
            for(int i = 0 ; i < 26 ; i++)
                sb.append(frq[i]+" ");
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
        }
    }
}

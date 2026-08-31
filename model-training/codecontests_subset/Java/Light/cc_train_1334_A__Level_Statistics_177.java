
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0)
        {
            int n = sc.nextInt();
            int[] levels = new int[n];
            int[] clears = new int[n];
            for(int i = 0 ; i < n  ; i++)
            {
                levels[i] = sc.nextInt();
                clears[i]=  sc.nextInt();
            }
            boolean flag = clears[0]<=levels[0];
            for(int i = 1 ; i < n ; i++)
            {
               if(clears[i]-clears[i-1]>levels[i]-levels[i-1] || levels[i]<levels[i-1] || clears[i]<clears[i-1])
               {
                   flag =false;
                   break;
               }
            }
            System.out.println(flag?"YES":"NO");
        }
    }
}

import java.util.*;

public class cf48{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            int ar[]=new int[n];
            int i=0;
            for(i=0;i<n;i++)
            {
                ar[i]=sc.nextInt();
            }
            if(ar[0]+ar[1]<=ar[n-1])
            {
                System.out.println(1+" "+2+" "+(n));
            }
            else
            {
                System.out.println(-1);
            }
        }
    }
}
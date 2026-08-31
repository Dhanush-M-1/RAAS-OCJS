import java.io.*;
import java.util.*;

public class p433a
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w[] = new int[n+1];
        w[0] = 0;
        int a=0,b=0;
        int sum = 0;
        for(int i=1;i<=n;i++)
        {
            w[i] = sc.nextInt();
            sum += w[i];
            if(w[i]==100) a++;
            else b++;
        }
        if(a==1) System.out.println("NO");
        else if(b%2==1 && a==0) System.out.println("NO");
        else if((sum/100)%2==0) System.out.println("YES");
        else System.out.println("NO");
    }
}
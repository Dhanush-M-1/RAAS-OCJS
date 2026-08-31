import java.util.*;
import java.io.*;

public class sol {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] h=new int[n];
        int[] a=new int[n];
        int ans=0;
        for (int x=0;x<n;x++)
        {
            h[x]=sc.nextInt();
            a[x]=sc.nextInt();
        }

        for (int x=0;x<n;x++)
        {
            for (int y=0;y<n;y++)
            {
                if(x!=y && h[x]==a[y])
                {
                    ans++;
                }
            }
        }

        System.out.println(""+ans);
    }

}

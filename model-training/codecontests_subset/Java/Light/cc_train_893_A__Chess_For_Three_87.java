import java.util.*;
import java.io.*;
public class codeforces
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i = 0 ;i<n;i++)
        arr[i]=sc.nextInt();
        int a=1;int b=1;int c=0;
        if(arr[0]==3)
        {
            System.out.println("NO");
            System.exit(0);
        }
        for(int i = 0 ;i<n;i++)
        {
            if(arr[i]==1)
            {
                b^=1;
                c^=1;
            }
            if(arr[i]==2)
            {
                a^=1;
                c^=1;
            }
            if(arr[i]==3)
            {
                a^=1;
                b^=1;
            }
            if(a+b+c!=2)
            {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
}
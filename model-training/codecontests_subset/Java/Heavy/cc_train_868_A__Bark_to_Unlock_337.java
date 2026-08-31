import java.io.*;
import java.util.*;
public class BarkToUnlock
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=sc.nextInt();
        String arr[]=new String[n];
        int f=-1,ye=0,ys=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.next();
            if(arr[i].equals(s))
                f=1;
            if(arr[i].charAt(1)==s.charAt(0))
                ye++;
            if(arr[i].charAt(0)==s.charAt(1))
                ys++;
        }
        if(ye>0 && ys>0)
            f=1;
        if(f==1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
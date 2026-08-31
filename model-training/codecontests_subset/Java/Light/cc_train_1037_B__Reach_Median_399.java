import java.util.*;
public class A
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        long aa=0,b=0;
        Arrays.sort(a);
        for(int i=0;i<n/2;i++)
        {
            if(a[i]>s)
            aa=aa+(a[i]-s);
            if(a[n-i-1]<s)
            b=b+(s-a[n-i-1]);
        }
        System.out.println(aa+b+Math.abs(a[n/2]-s));
    }
}

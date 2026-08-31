import java.io.*;
import java.util.*;
public class Main
{
    static int binarySearch(long a[],long n)
    {
        int left=1,right=a.length-1,mid;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(a[mid-1]<n&&a[mid]>=n)
            return mid;
            if(a[mid]<n)
            left=mid+1;
            else
            right=mid-1;
        }
        return 0;
    }
    public static void main(String args[])throws IOException
    {
        long l,y,d,min=Integer.MAX_VALUE,max=0l,sum=0l;
        int ans=0,di=0,n,m,flag=0,t;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int i,j=0;
        boolean a[]=new boolean[m];
        // long b[]=new long[n];
        for(i=0;i<n;i++)
        {
            t=sc.nextInt();
            for(j=0;j<t;j++)
            {
                di=sc.nextInt();
                a[di-1]=true;
            }
        }
        for(i=0;i<m;i++){
        if(!a[i]){
        System.out.println("NO");return;}}
        System.out.println("YES");
    }
}
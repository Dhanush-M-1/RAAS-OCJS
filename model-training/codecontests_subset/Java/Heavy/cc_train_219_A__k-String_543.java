import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class MainTest
{
    static void print(int a[])
    {
        for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
        System.out.println();
    }
    static void print(long a[])
    {
        for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
        System.out.println();
    }
    static void println(int a[])
    {
        for(int i=0;i<a.length;i++) System.out.println(a[i]+" ");
    }
    
    static int sum(int []a)
    {
        int res=0;
        for(int i=0;i<a.length;i++) res+=a[i];
        return res;
    }
    /*static int getMax()
    {
        int max=0;
        int k=0;
        for(int i=0;i<a.length;i++) if(a[i]>max) {max=a[i]; k=i;}
        a[k]=-1;
        return max;
    }*/
    static int[] getSimple(int from,int to)
    {
        int a[]=new int[to-from];
        for(int i=0;i<a.length;i++) a[i]=from+i;
        //print(a);
        int sum=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>0)
            {
                for(int j=i+1;j<a.length;j++) if(a[j]%a[i]==0) a[j]=0;
                sum++;
            }
        }
        int b[]=new int[sum];
        sum=0;
        for(int i=0;i<a.length;i++) if(a[i]>0) {b[sum]=a[i]; sum++;}
        //System.out.println("SIMPLE!");
        //print(a);
        return b;
    }
    static int check(int a)
    {
        if(a==1) return 0;
        else return 1;
    }
    static int[] inverse(int []a, int x,int y)
    {
        int b[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            if(i>=x&&i<=y)
            {
                if(a[i]==1) b[i]=0;
                else b[i]=1;
                continue;
            }
            b[i]=a[i];
        }
        return b;
    }
    //static int a[];
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String str=in.next();
        if(n==1) {System.out.println(str); return;}
        String time="";
        for(int i=0;i<str.length();i++)
        {
            if(time.isEmpty()) {time+=(char)str.charAt(i); continue;}
            if(time.indexOf(str.substring(i, i+1))<0) {time+=(char)str.charAt(i); continue;}
        }
        int a[]=new int[time.length()];
        for(int i=0;i<a.length;i++)
        {
            a[i]=0;
            for(int j=0;j<str.length();j++)
            {
                if(time.charAt(i)==str.charAt(j)) a[i]++;
            }
            if(a[i]%n>0) {System.out.println("-1"); return;}
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<a.length;j++)
            {
                for(int t=0;t<a[j]/n;t++)   System.out.print((char)time.charAt(j));
            }
        }
    }
}

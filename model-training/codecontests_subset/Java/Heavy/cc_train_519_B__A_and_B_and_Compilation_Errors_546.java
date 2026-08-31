import java.util.*;
public class ABCompilationError
{
    static Scanner s=new Scanner(System.in);
    public static void main(String args[])
    {
        int n=s.nextInt(),i;
        long a[]=new long[n],b[]=new long[n-1],c[]=new long[n-2];
        input(a);input(b);input(c);
        Arrays.sort(a);Arrays.sort(b);Arrays.sort(c);
        System.out.println(compare(a,b));
        System.out.println(compare(b,c));
    }
    public static void input(long a[])
    {
        for(int i=0;i<a.length;i++)
        a[i]=s.nextLong();
    }
    public static long compare(long a[],long b[])
    {
        int i;
        for(i=0;i<b.length;i++)
        if(a[i]!=b[i])
        break;
        return a[i];
        
    }
}
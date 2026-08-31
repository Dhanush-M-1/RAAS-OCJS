import java.util.Scanner;
public class Solution {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        long n=s.nextLong();
        long p=s.nextLong();
        long w=s.nextLong();
        long d=s.nextLong();
        findMatches(n,p,w,d);
    }
    public static void findMatches(long n,long p,long w,long d)
    {
        long min=(long)Math.ceil(n-(p*1.0)/d);
        long max=(long)Math.floor(n-(p*1.0/w));
        int count=0;
        for(long z=Math.max(min,0);z<=max && count<=10000000;z++,count++)
        {
            if( ((p-d*(n-z))%(w-d))==0 && ((w*(n-z)-p)%(w-d))==0 )
            {
                long x=((p-d*(n-z))/(w-d));
                long y=((w*(n-z)-p)/(w-d));
                System.out.println(x+" "+y+" "+z);
                return;
            }
        }
        System.out.println(-1);
    }
}
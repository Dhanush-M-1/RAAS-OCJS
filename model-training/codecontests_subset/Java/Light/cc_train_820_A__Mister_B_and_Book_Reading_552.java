import java.util.*;
public class Main{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long c=sc.nextLong();
        long vo=sc.nextLong();
        long v1=sc.nextLong();
        long a=sc.nextLong();
        long l=sc.nextLong();int c1=1;
        long t=vo,t1=vo;
        while(t<c)
        {
            c1++;
            t1=Math.min(t1+a,v1);
            t+=t1-l;
            //System.out.println(t1+" "+t);
        }
        System.out.println(c1);
    }
}


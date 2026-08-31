import java.util.*;
public class L1
{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int n,i,c1=0,c2=0;
        String h;
        n=sc.nextInt();
        h=sc.next();
        for(i=0;i<n;i++)
        {
            if(h.charAt(i)=='1')
            c1++;
            else
            c2++;
             }
        if(c1==c2)
        {
        System.out.println("2");
        System.out.println(h.charAt(0)+" "+h.substring(1,n));
    }
        else
        {
        System.out.println("1");
        System.out.println(h);
    }
}
}
        
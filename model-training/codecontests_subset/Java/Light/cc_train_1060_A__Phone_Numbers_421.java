import java.util.*;
public class bac
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=0;
        String s=sc.next();
        for(int x=0;x<n;x++)
        {
            if(s.charAt(x)=='8')
            {
                c++;
            }
        }
        n/=11;
        System.out.println(n<c?n:c);
    }
}
import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();
            long n = c+1;
            if(n%3 == 1)
            {
                System.out.println(""+a);
            }
            if(n%3 == 2)
            {
                System.out.println(""+b);
            }
            if(n%3 == 0)
            {
                System.out.println(""+(a^b));
            }
        }
    }
}
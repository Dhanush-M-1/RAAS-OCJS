import java.util.*;

public class A248
{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a=0,b=0;

        for(int i=0;i<n;i++)
        {
            int inp = sc.nextInt();
            if(inp==100)
                a++;
            else
                b++;
        }
           if(a%2==1) System.out.println("NO");
           
           if(a%2==0 && a!=0) System.out.println("YES");
           if(a==0 && b%2==1)System.out.println("NO");
           if(a==0 && b%2==0)System.out.println("YES");


      }

}

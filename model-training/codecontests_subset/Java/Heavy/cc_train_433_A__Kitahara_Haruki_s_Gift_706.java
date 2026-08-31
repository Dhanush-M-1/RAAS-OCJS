import java.util.*;

public class MyClass
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
       
        int c100 = 0;
        int c200 = 0;
        for(int i=0;i<n;i++)
        {
          int num = s.nextInt();
          if(num==100)
          {
             c100++;
          }
          else
          {
            
             //c100 = c100 -2;
             c200++;
          }
        }
       // System.out.println(c100);
        //System.out.println(c200);
        if(c200%2 == 1)
        {
           c100 = c100 - 2;
           c200 = c200 - 1;
        }
        //System.out.println(c100);
        //System.out.println(c200);
        if(c100%2!=0)
        {
            System.out.println("NO");
        }
        else if(c100>=0 && (c100%2==0 && c200%2==0))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}

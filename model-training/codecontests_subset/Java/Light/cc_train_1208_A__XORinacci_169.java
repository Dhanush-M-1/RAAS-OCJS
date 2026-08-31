import java.util.*;
 
public class Ashu
{  
    public static int do_xor(int a,int b,int c)
    {
       if(c%3 == 0)
           return a;
     else if(c%3 == 1)
           return b;
       else
           return a^b;
    }
       
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a,b,c;
        
        for(int i=0;i<n;i++)
        {
           a = in.nextInt();
           b = in.nextInt();
           c = in.nextInt(); 
          
           System.out.println(do_xor(a,b,c)); 
        }
    }
}
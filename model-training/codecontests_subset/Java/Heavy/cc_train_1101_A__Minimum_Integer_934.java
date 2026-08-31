import java.util.Scanner;
public class code
{
    static int q,l,r,d;
    public static void main (String[] args)
    {
       Scanner ob=new Scanner(System.in);
       q=ob.nextInt();
       while(q>0)
       {
           q--;
            l=ob.nextInt();
            r=ob.nextInt();
            d=ob.nextInt();
            for(int x=d;;x=x+d)
            {
                if(x>=l&&x<=r)
                {
                   
                    x=r-(r%d);
                    
                }
                else
                {
                    if(x%d==0)
                    {
                        System.out.println(x);
                        break;
                    }
                }
            }
       }/* code */
    }
}
import java.util.*;
import java.util.Arrays;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c,count=0,i=0;
        if(b>a)
        {
            c=b-a;
        }
        else
        {
            c=a-b;
        }
        if(c==1)
        {
            System.out.println("1");
        }
        
        else
        {
            
            while(c!=0)
            {
                i++;
                if(c==1)
                {
                    count=count+i;
                    c--;
                }
                else
                {
                    count=count+(2*i);
                    c=c-2;
                }
            }
            System.out.println(count);
        }
    }
}
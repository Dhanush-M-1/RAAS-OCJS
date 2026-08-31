import java.util.Scanner;
public class Main
{
public static void main (String[] args) throws java.lang.Exception
{
    Scanner input=new Scanner(System.in);
         int t=input.nextInt();
         while(t>0)
         {
        int n=input.nextInt();
        int a=0,count=0;
        int f=n;
        while(f!=1)
        {
            if(f%6==0)
            {
                f=f/6;
                count++;
              
            }
            else
            {
                count++;
                f=f*2;
                if(f%6==0)
                {
                    f=f/6;
                     count++;
                    
                }
                else
                {
                    a=1;
                  
                    break;
                }
            }
        }
        if(a==1)
        {
            System.out.println("-1");
        }
        else
        {
        System.out.println(count);
        }
        t--;
         }
}
}
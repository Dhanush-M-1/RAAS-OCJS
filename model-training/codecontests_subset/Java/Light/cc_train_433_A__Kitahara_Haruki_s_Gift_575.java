
import java.util.Scanner;
    public class Java_mid  
    {
        public static void main(String []args)
        {
            Scanner abd = new Scanner(System.in);
            int n=abd.nextInt();
            int a[]=new int [n];
            for (int i = 0; i < a.length; i++)
            {
                a[i]=abd.nextInt();
            }
            int sum=0,sum1=0;
            for (int i = 0; i <= a.length-1; i++)
            {
                if(a[i]==100)sum+=a[i];
                else sum1+=a[i];                              
            }
            
            if(n>1)
            if(sum%200==0)
            {
                if(sum1/200!=n||sum1%400==0)
                {
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }
            else System.out.println("NO");
            else System.out.println("NO");
        }
    }
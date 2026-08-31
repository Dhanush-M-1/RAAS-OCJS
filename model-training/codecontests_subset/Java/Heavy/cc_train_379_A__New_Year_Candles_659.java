import java.util.Scanner;

public class Candles 
{

    public static void main(String[] args) 
    {
        Scanner Scanner = new Scanner(System.in);
        int a = Scanner.nextInt();
        int b = Scanner.nextInt();
        int sum;
        int r = a%b ;
        sum =a+(a/b);
        
        if (a < b)
            System.out.println(sum);
        else
        {
            while(a/b != 0)
            {
                a=a/b;
                sum=sum+(a/b);
                r=r+(a%b);
            }
            while ( r >= b )
            {
                sum = sum + (r/b);
                r = r%b + (r/b);
            }
            System.out.println(sum);
        }
    
    }
    
}
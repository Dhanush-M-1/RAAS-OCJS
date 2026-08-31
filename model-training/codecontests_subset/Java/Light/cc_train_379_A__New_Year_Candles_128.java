import java.util.Scanner;
public class Main {
    public static void main(String [] args)
    {
        Scanner input = new Scanner (System.in);
        int  a=input.nextInt();
        int  b=input.nextInt();

        int hrs ; 
        int rest;
        int newa;
        if ( a >= 1 && a <= 1000 && b >=2 && b <= 1000  )
        {
            hrs=a;
            newa=a;
            rest=0;
            while( newa!=0 )
            {
            newa=a/b;
            hrs=newa+hrs;
            rest=a%b;
            a=newa+rest;
            
            }   
                                System.out.println(hrs);

        }

    }
}

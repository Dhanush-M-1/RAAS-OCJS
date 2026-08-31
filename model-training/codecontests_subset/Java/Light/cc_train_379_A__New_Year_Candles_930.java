import java.util.Scanner;

public class Plantilla
{
    public static void main(String[] args)
    {
        Scanner is = new Scanner( System.in );
        short a = is.nextShort(), b = is.nextShort(), answer = a;
        do{
            answer += (short)(a/b);
            a = (short)((short)(a/b)+ (short)(a%b));
        }while( a >= b );
        System.out.println(answer);
    }
}
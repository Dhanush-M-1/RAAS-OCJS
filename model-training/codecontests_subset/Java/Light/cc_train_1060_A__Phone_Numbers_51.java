import java.util.Scanner;

public class PhoneNumbers
{
    public static void main( String [] args )
    {
        Scanner input = new Scanner( System.in );
        int n = input.nextInt();
        String str = input.next();

        long eightCounter = str.chars().filter(x -> x == '8').count();
        long len = str.length() / 11;

        System.out.println( Math.min(len, eightCounter) );
    }
}
import java.util.*;
public class FakeNP
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(System.in);
        long num1=scan.nextLong();
        long num2=scan.nextLong();
        if(num1==num2&&num1%2!=0)
            System.out.println(num1);
        else
            System.out.println(2);
    }
}

import java.util.Scanner;

public class A1189 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String input=sc.next();
        int a=0;
        int b=0;
        for (int i=0;i<input.length();i++)
        {
            if (input.charAt(i)=='1')
            {
                a++;
            }else {
                b++;
            }
        }
        if (a!=b)
        {
            System.out.println("1");
            System.out.println(input);
        }else {
            System.out.println("2");
            for (int i=0;i<input.length()-1;i++)
            {
                System.out.print(input.charAt(i));
            }
            System.out.print(" "+input.charAt(input.length()-1));

        }
    }
}

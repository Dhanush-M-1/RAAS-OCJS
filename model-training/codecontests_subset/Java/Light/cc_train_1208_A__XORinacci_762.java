import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for (int i=0;i<test;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=a^b;
            int n=sc.nextInt()+1;
            if ( n%3==0 )
            {
                System.out.println(c);
            }
            else if (n%3==2)
            {
                System.out.println(b);
            }
            else if (n%3==1)
                System.out.println(a);

        }
    }

}

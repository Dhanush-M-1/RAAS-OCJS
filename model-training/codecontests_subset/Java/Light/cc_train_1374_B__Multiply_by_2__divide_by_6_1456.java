import java.util.Scanner;
public class MyClass 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int output=0;
        for (int i=0; i<t; i++)
        {
            int n=sc.nextInt();
            if (n==1)
                output=0;
            else
            {
                int two=0;
                int three=0;
                while (n%2==0)
                {
                    two++;
                    n/=2;
                }
                while (n%3==0)
                {
                    three++;
                    n/=3;
                }
                if (n==1 && two<three)
                {
                    output=(three*2)-two;
                }
                else if (two==three && two!=0 && n==1)
                    output=two;
                else
                    output=-1;
            }
            System.out.println(output);
        }
    }
}
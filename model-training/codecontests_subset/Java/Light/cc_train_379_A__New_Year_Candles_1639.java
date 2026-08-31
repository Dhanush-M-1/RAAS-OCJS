import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner ob=new Scanner(System.in);
        int g=0,u=ob.nextInt();
        int v=ob.nextInt();
        System.out.print((1-(u*v))/(1-v));
    }
}
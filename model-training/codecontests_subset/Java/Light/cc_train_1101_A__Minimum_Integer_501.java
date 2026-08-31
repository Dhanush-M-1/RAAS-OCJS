import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-->0)
        {
            long l = sc.nextLong(), r = sc.nextLong(), d = sc.nextLong();
            int flag=0;
            if(d<l || d>r)
                System.out.println(d);
            else
                System.out.println(r+d-(r%d));
        }
    }
}
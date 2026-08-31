import java.util.Arrays;
import java.util.Scanner;

public class a123 {

    public static void debug(Object... obs)
    {
        System.out.println(Arrays.deepToString(obs));
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        
        int hv = (c*a - c*b);
        if(hv%b==0)
        {
            System.out.println(hv/b);
        }
        else
        {
            System.out.println(hv/b + 1);
        }
    }
}
import java.awt.*;
import java.lang.String;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        int c,v_0,v_1,a,l;
        int current = 0;
        int days = 0;
        Scanner input = new Scanner(System.in);
        c = input.nextInt();
        v_0 = input.nextInt();
        v_1 = input.nextInt();
        a = input.nextInt();
        l = input.nextInt();
        while(current < c )
        {
            days++;
            if(days == 1)
            {
                current = v_0;
            }
            else
            {
                v_0 +=a;
                if(v_0 > v_1)
                {
                    v_0 = v_1;
                }
                current = current + v_0 - l;

            }
        }
        System.out.println(days);

    }
}

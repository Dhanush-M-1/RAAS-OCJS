/**
 * Created by Администратор on 23.05.2017.
 */
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int v0 = sc.nextInt();
        int vmax = sc.nextInt();
        int a = sc.nextInt();
        int l = sc.nextInt();
        int day = 0;

        c-=v0;
        day++;
        v0 -= l;
        vmax -=l;

        while (c > 0)
        {
            v0+=a;
            if (v0 > vmax) v0 = vmax;
            c-=v0;
            day++;
        }

        System.out.print(day);
    }
}



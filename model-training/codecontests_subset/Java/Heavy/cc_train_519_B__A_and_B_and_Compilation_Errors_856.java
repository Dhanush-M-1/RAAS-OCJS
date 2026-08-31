/**
 * Created by Григорий on 28.02.15.
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class B {
    public static void main(String[] argc)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int[] b = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            b[i] = in.nextInt();
        int[] c = new int[n - 2];
        for (int i = 0; i < n - 2; i++)
            c[i] = in.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        boolean flag = false;
        for (int i = 0; i < n - 1; i++)
        {
            if (b[i] != a[i])
            {
                System.out.println(a[i]);
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println(a[n - 1]);
        flag = false;
        for (int i = 0; i < n - 2; i++)
        {
            if (c[i] != b[i])
            {
                System.out.println(b[i]);
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println(b[n - 2]);
    }
}

import java.math.*;
import java.io.*;
import java.util.*;
public class b{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        int p = 0,q = 0;
        for (int i = 0 ;i < n;i++)
        {
            if (s[i] == 'I') p++;
            if (s[i] == 'A') q++;
        }
        if (p == 1) System.out.println(1);
        else if (p > 1) System.out.println(0);
        else System.out.println(q);
    }
}

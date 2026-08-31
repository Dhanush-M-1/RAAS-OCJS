import java.io.*;
import java.util.*;

public class p348a
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n+1];
        double sum = 0;
        for (int i=1; i<=n;i++)
        {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        Arrays.sort(a);
        System.out.println((int) Math.max(Math.ceil(sum/(n-1)),a[n]));
    }
}
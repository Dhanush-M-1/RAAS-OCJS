import java.util.*;
import java.lang.Math;
public class Solution
{
    public static int minTiredness(int a, int b)
    {
        int mid;
        mid = (a+b)/2;
        if((mid == a) || (mid == b))
        {
            return 1;
        }
        int dist4a = Math.abs(mid-a);
        int dist4b = Math.abs(mid-b);
        int tiredness = (dist4a*(dist4a+1)/2) + (dist4b*(dist4b+1)/2); 
        return tiredness;
    }
    public static void main(String... args)
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(minTiredness(a, b));
    }
}

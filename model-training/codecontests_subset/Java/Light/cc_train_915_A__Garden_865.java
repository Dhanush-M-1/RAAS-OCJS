import java.util.Arrays;
import java.util.Scanner;

public class Garden
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();

        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
            arr [i] = input.nextInt();

        long ans = Arrays.stream(arr).map(x -> (k % x == 0) ? (k / x): Integer.MAX_VALUE)
                                     .min().getAsInt();
        System.out.println(ans);
    }
}
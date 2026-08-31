import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Lol {
    public static void main(String [] args)
    {
        Scanner s = new Scanner(System.in);
        int[][] arr = new int[3][2];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                arr[i][j] = s.nextInt();
            }
        }
        int allsums = arr[0][0] + arr[0][1];
        int secsum = -arr[0][0] - arr[1][0] - arr[2][0];
        int a = (allsums + secsum) / -2;
        int b = -a + arr[0][0];
        int c = -a + arr[1][0];
        int d = -a+ arr[2][0];
        if(a <= 0 || b <= 0 || c <= 0 || d <= 0 || a > 9 || b > 9 || c > 9 || d > 9)
        {
            System.out.println(-1);
        }
        else if(a == c || c == d || d == b || a == d || b == c ||a == b)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(a + " " + b);
            System.out.println(c + " " + d);
        }


    }
}

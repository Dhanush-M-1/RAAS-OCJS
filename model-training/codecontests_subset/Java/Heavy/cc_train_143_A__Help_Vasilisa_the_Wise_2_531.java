import java.util.Scanner;


public class Prob143A
{
    public static void main( String[] Args )
    {
        Scanner scan = new Scanner( System.in );

        int[] r = new int[] { scan.nextInt(), scan.nextInt() };
        int[] c = new int[] { scan.nextInt(), scan.nextInt() };
        int[] d = new int[] { scan.nextInt(), scan.nextInt() };

        boolean possible = true;
        int[][] arr = new int[2][2];

        for ( int i = 0; i < 2; i++ )
        {
            for ( int j = 0; j < 2; j++ )
            {
                arr[i][j] = r[i] + c[j] - d[( i + j + 1 ) % 2];
                possible &= arr[i][j] % 2 == 0;
                possible &= arr[i][j] > 0;
                possible &= arr[i][j] < 20;
                for ( int k = 0; k < i * 2 + j; k++ )
                    possible &= arr[i][j] != arr[k / 2][k % 2];
            }
        }

        if ( possible )
            for ( int i = 0; i < 2; i++ )
                System.out.println( arr[i][0] / 2 + " " + arr[i][1] / 2 );
        else
            System.out.println( -1 );
    }
}

import java.util.*;

public class k_string
{
    static int n;

    static String str;

    static int[] az = new int[26];

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        n = in.nextInt();
        str = in.next();
        for ( int i = 0; i < str.length(); i++ )
            az[str.charAt( i ) - 97]++;
        for ( int i = 0; i < 26; i++ )
        {
            if ( az[i] % n != 0 )
            {
                System.out.println( -1 );
                System.exit( 0 );
            }
            az[i] /= n;
        }
        str = "";
        for ( int i = 0; i < 26; i++ )
            for ( int j = 0; j < az[i]; j++ )
            {
                str += (char)( i + 97 );
            }
        for ( int i = 0; i < n; i++ )
            System.out.print( str );
        System.out.println();
        in.close();
        System.exit( 0 );
    }
}
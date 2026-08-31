import java.util.*;

public class help_vasilia
{
    static int r1, r2, c1, c2, d1, d2;

    static boolean done;

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        r1 = in.nextInt();
        r2 = in.nextInt();
        c1 = in.nextInt();
        c2 = in.nextInt();
        d1 = in.nextInt();
        d2 = in.nextInt();
        for ( int a = 1; a < 10 && !done; a++ )
            for ( int b = 1; b < 10 && !done; b++ )
                for ( int c = 1; c < 10 && !done; c++ )
                    for ( int d = 1; d < 10 && !done; d++ )
                        if ( a + b == r1 && c + d == r2 && a + c == c1
                            && b + d == c2 && a + d == d1 && b + c == d2
                            && a != b && b != c && c != d && a != c && b != d
                            && a != d )
                        {
                            System.out.println( a + " " + b + '\n' + c + " " + d );
                            done = true;
                        }
        if ( !done )
            System.out.println( -1 );
        in.close();
        System.exit( 0 );
    }
}
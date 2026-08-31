import java.util.Scanner;

/**
 *
 * @author Mostafa
 */
public class Games {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereScanner 
        Scanner in = new Scanner ( System.in ) ;
        byte n = in.nextByte() , i ;
        byte x[] = new byte [n] ;
        byte y[] = new byte [n] ;
        for ( i = 0 ; i < n ; ++i )
        {
            x[i] = in.nextByte() ;
            y[i] = in.nextByte() ;
        }
        byte j = 0 ;
        short c = 0 ;
        for ( i = 0 ; i < n ; ++i )
            for ( j = 0 ; j < n ; ++j )
            {
                if ( x[i] == y[j] )
                    ++c;
            }
        System.out.println(c);
    }
}

import java.util.Scanner;

/**
 *
 * @author Mostafa
 */
public class Test62 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int x = in.nextInt() ;
        int x1 = in.nextInt() ;
        int x2 = in.nextInt() ;
        int x3 = in.nextInt() ;
        int x4 = in.nextInt() ;
        if ( ( x + x1 + x2 + x3 + x4 ) % 5 == 0 && (( x + x1 + x2 + x3 + x4 ) != 0) )
            System.out.println((x + x1 + x2 + x3 + x4) / 5);
        else
            System.out.println(-1);
    }
    
}
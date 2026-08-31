import static java.lang.System.* ;
import java.util.Scanner;

/**
 *
 * @author Kinan
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n ; 
        String s ;
        Scanner scanner = new Scanner(in) ;
        n=scanner.nextInt() ; 
        s = scanner.next() ; 
        s=s.replaceAll("[u]+", "u") ;
        s=s.replaceAll("[a]+", "a") ;
        s=s.replaceAll("[i]+", "i" );
        s=s.replaceAll("[y]+", "y");
        s=s.replaceAll("[o]{3,}", "o") ;
        s=s.replaceAll("[e]{3,}", "e") ;
                
        System.out.println(s); 
        
    }
    
}

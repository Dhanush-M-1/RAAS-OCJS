import java.util.Scanner;
 
/**
 *
 * @author Hp
 */
public class Force2 {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        
       Scanner input = new Scanner(System.in);
 
 
 
       long t= input.nextLong();
       for ( long i = 0; i < t; i++) {
       long  l= input.nextLong();
       long  r = input.nextLong();
       long  d= input.nextLong();
            if (d>r || d<l) {
              System.out.println(d);   
           }
          else if (r%d == 0) {
               System.out.println(r+d);   
           }else
                System.out.println(r+(d-r%d)); 
       }
    }
}
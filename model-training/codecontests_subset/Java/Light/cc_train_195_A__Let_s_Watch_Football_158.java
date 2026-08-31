import java.util.Scanner;

/**
 *
 * @author imac
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        
        double z = Math.ceil(((a*c) - (b*c))/(double)b);
        
        System.out.println((int)z);
    }

}
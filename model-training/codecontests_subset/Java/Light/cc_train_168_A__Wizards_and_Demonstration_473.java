import java.util.Scanner;

/**
 *
 * @author aboragab
 */
public class A_WizardsAndDemonstration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(((int)Math.ceil(((y/100.0)*n)-x))>=0?(int)Math.ceil(((y/100.0)*n)-x):0);
    } 
}

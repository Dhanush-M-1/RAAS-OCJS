import java.util.Scanner;
/**
 *
 * @author lkoed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++) {
            
            int len = sc.nextInt();
            int[] sides = new int[len];
            for (int j = 0; j < len; j++) {
                sides[j] = sc.nextInt();
            }
            
            System.out.println((sides[0]+sides[1])<=sides[sides.length-1]?"1"+" "+"2"+" "+sides.length:"-1");
            
        }       
    }   
}

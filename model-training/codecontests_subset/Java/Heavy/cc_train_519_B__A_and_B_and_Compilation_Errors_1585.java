
import java.util.Scanner;

/**
 *
 * @author Matias
 */
public class Numeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num1=0;
        int num2=0;
        int num3=0;
        int j=0;
        Scanner intro = new Scanner(System.in);
        String n = intro.nextLine();
        String algo = intro.nextLine();
        String[] error = algo.split(" ");
        int[] resultado = new int[error.length];
        String algo2 = intro.nextLine();
        String[] error2 = algo2.split(" ");
        int[] resultado2 = new int[error2.length];
        String algo3 = intro.nextLine();
        String[] error3 = algo3.split(" ");
        int[] resultado3 = new int[error3.length];
        for (int i = 0; i < error.length; i++) {
            resultado[i] = Integer.parseInt(error[i]); 
            num1 += resultado[i];
        }
        for (int i = 0; i < error2.length; i++) {
            resultado2[i] = Integer.parseInt(error2[i]);
            num2 += resultado2[i]+j;
        }
        for (int i = 0; i < error3.length; i++) {
            resultado3[i] = Integer.parseInt(error3[i]);
            num3 += resultado3[i]+j;
        }
        System.out.println(num1-num2);
        System.out.println(num2-num3);
        
                
    }
    
    
}
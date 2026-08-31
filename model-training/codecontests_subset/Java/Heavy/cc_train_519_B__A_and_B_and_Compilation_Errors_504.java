
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class AyBcompiulacionErroresS2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       
        int cErrores = Integer.parseInt(s.nextLine());
        
        String [] bugs = new String [cErrores];
        String [] bugs2 = new String [cErrores-1];
        String [] bugs3 = new String [cErrores-2];
         
        String linea1 = s.nextLine();
        String linea2 = s.nextLine();
        String linea3 = s.nextLine();
        
        bugs = (linea1.split(" "));
        bugs2 = (linea2.split(" "));
        bugs3 = (linea3.split(" "));
        int suma1 = 0;
        int suma2 = 0;
        int suma3 = 0;
         
        for (int i = 0; i < cErrores; i++) {
            
            suma1 = suma1+Integer.parseInt(bugs[i]);
            
            if (i<cErrores-1) {
                
                suma2 = suma2+Integer.parseInt(bugs2[i]);
            }
            if (i<cErrores-2) {
               
                suma3 = suma3+Integer.parseInt(bugs3[i]);
            }
        }
        
        System.out.println(suma1-suma2);
        System.out.println(suma2-suma3);
    }
    
}

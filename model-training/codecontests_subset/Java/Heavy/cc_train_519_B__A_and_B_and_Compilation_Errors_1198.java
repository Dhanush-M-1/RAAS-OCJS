import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();                                      
        int err1 [] = new int [n];
        int err2 [] = new int [n-1];
        int err3 [] = new int [n-2];
        
        
        for (int i = 0; i < err1.length; i++) {
            err1 [i] = leer.nextInt();
        }
        for (int i = 0; i < err1.length-1; i++) {
            err2 [i] = leer.nextInt();
        }
        for (int i = 0; i < err1.length-2; i++) {
            err3 [i] = leer.nextInt();
        }
        
        Arrays.sort(err1);
        Arrays.sort(err2);
        Arrays.sort(err3);
        
        int primero = -1;
        int segundo = -1;
        
        for (int i = 0; i < n-1; i++) {
            if (err2 [i] != err1 [i]) {
                primero = err1 [i];
                break;
            }
        }
        if (primero == -1) {
            primero = err1[n-1];
        }

        for (int i = 0; i < n-2; i++) {
            if (err3 [i] != err2 [i]) {
                segundo = err2 [i];
                break;
            }
        }
        if (segundo == -1) {
            segundo = err2[n-2];
        }
        
        System.out.println(primero);
        System.out.println(segundo);
        
    }
    
    
}
  					 								 					 		 		 		
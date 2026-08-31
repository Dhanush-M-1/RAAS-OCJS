
import java.util.Scanner;

/**
 * @author Leandro
 *
 */
public class AyB {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int errores = entrada.nextInt();
        int[ ] arreglo = new int[3];
        for(int i=0; i<errores; i++){
            int numero = entrada.nextInt();
            arreglo[0] += numero;
        }
        for(int i=0; i<errores-1; i++){
            int numero = entrada.nextInt();
            arreglo[1] += numero;
        }
        for(int i=0; i<errores-2; i++){
            int numero = entrada.nextInt();
            arreglo[2] += numero;
        }
        System.out.println(arreglo[0]-arreglo[1]);
        System.out.println(arreglo[1]-arreglo[2]);
    }

}
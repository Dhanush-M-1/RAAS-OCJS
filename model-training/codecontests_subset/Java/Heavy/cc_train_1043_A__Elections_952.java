import java.util.Scanner;

/**
 *
 * @author mpadre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        int[] a = new int[i];
        int c = i;
        int soma = 0;
        int j;
        int maior = 0;

        for (j = 0; j < i; j++) {
            a[j] = s.nextInt();
            soma += a[j];
            if (a[j] > maior) {
                maior = a[j];
            }

        }
        int valor = 0, v = 1;
        j = 0;
        while (true) {

            valor += maior - a[j];
            if (valor > soma) {
                System.out.println(maior);
                break;
            }

            if (j == i - 1) {
                j = 0;
                maior++;
                valor =0;

            } else {
                j++;
            }

        }

    }

}

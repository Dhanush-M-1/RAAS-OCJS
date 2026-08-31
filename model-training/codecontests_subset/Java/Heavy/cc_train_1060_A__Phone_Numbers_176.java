import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String v = s.next();
        int[] numeros = new int[v.length()];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(v.charAt(i) + "");
        }

        int nn = (int) N / 11;

        int q = 0;

        for (int num : numeros) {
            if (num == 8) {
                q++;
            }
        }

        if (q >= nn) {
            System.out.println(nn);
        } else if(q >= 0) {
            System.out.println(q);
        }

    }
}
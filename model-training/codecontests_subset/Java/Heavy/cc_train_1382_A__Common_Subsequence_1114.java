import java.util.ArrayList;
import java.util.Scanner;

public class CommonSubSequence {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int quantidadeNumeros = input.nextInt();

        int[] array1;
        int[] array2;

        ArrayList resposta = new ArrayList<>();

        while(quantidadeNumeros > 0) {

            array1 = new int[input.nextInt()];
            array2 = new int[input.nextInt()];

            for(int i = 0; i < array1.length; i++)
                array1[i] = input.nextInt();

            for(int i = 0; i < array2.length; i++)
                array2[i] = input.nextInt();

            int qCorres = 0;
            int value = 0;

            EXTERN : for(int i = 0; i < array1.length; i++) {
                for(int j = 0; j < array2.length; j++) {
                    if(array1[i] == array2[j]) {
                        qCorres += 1;
                        value = array2[j];
                        break EXTERN;
                    }
                }
            }

            if(qCorres != 0) {
                resposta.add("YES");
                resposta.add(qCorres);
                resposta.add(value);
            }
            else
                resposta.add("NO");

            quantidadeNumeros -= 1;
        }

        int index = 0;
        while(index < resposta.size()) {
            if (resposta.get(index).equals("YES")) {
                System.out.println("YES");
                System.out.println(resposta.get(index + 1) + " " + resposta.get(index + 2));
                index += 2;
            } else
                System.out.println("NO");
            index += 1;
        }
    }
}

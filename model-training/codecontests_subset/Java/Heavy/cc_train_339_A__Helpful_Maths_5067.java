import java.util.Scanner;
import java.util.Arrays; 

public class Helpful_Maths {
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		String suma_entrada = "";
		int j =0;
		int longitud = 0;

		suma_entrada = entrada.nextLine(); 
		longitud = suma_entrada.length();

		int arr_numeros [] = new int [((longitud/2)+1)];


		for (int i = 0; i < longitud ; i++) {
			switch (suma_entrada.charAt(i)){
				case '1':
				arr_numeros [j] = 1;
				j++;
				break;

				case '2':
				arr_numeros [j] = 2;
				j++;
				break;

				case '3':
				arr_numeros [j] = 3;
				j++;
				break;
			}
		}

		Arrays.sort(arr_numeros);

		for (int i = 0; i < arr_numeros.length; i++ ) {

			System.out.print(arr_numeros[i]);
			if(i < arr_numeros.length-1){
			System.out.print("+");
			}
		}
	}
}
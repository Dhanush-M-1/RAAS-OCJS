import java.util.Scanner;

public class kString {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] alfabeto = new int[26]; 
		String stringCompleta = sc.next();
		String resultado = "";
		String resposta = "";
		if(stringCompleta.length() % k != 0) {
			System.out.println("-1");
			return;
		}
		char[] array = stringCompleta.toCharArray();
		for(int i = 0; i < array.length; i++) {
			int letra =  (int) array[i];
			alfabeto[letra - 97] ++;
		}
		for(int j = 0; j < alfabeto.length; j++) {
			if(alfabeto[j] != 0) {
				if(alfabeto[j] % k != 0) {
					System.out.println("-1");
					return;
				}
				else {
					int iterador = alfabeto[j] / k;
					int aux = j + 97;
					char l = Character.valueOf((char) aux);
					while(iterador > 0) {
						resultado = resultado + l;
						iterador--;
					}
				}
			}
		}
		for(int w = 0; w < k; w ++) {
			resposta = resposta + resultado;
		}
		System.out.println(resposta);
	}
}

	 		 	 	 	          	 			    	
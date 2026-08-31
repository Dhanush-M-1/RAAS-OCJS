import java.util.Scanner;
public class Kstring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String cad = sc.next();
		int[] ar = new int[26];
		boolean correcto = true;
		String cadFin = "";
		for(int i=0; i<cad.length(); i++) {
			ar[(int)cad.charAt(i) - 97]++;
		}
		for(int i=0; i<ar.length; i++) {
			if(ar[i] > 0 && ar[i] % k != 0) {
				correcto = false;
			}
		}
		if(correcto) {
			for(int i=0; i<k; i++) {
				for(int j=0; j<ar.length; j++) {
					if(ar[j] != 0) {
						for(int f=0; f<ar[j] / k; f++) { 
							cadFin += (char)(j + 97);
						}
					}
				}
			}
			System.out.println(cadFin);
		}
		else {
			System.out.println(-1);
		}
	}
}

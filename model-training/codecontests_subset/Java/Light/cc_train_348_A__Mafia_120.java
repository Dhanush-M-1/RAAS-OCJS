import java.util.Scanner;
public class Mafia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cantidad = sc.nextInt();		
		long suma = 0;
		long max = 0;
		long a = 0;
		
		for (int i = 0; i < cantidad; i++) {
			a = sc.nextLong();
			if (a > max) {
				max = a;
			}
			suma += a;
		}	
		
		long resu = (long)Math.ceil(suma/(cantidad-1.0d));
		if (resu > max) {
			System.out.println(resu);
		}
		else {
			System.out.println(max);	
		}
	}
}

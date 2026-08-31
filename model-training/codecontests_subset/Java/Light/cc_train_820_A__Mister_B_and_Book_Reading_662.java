import java.util.Scanner;
public class Prueba {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int v0 = sc.nextInt();
		int v1 = sc.nextInt();
		int a = sc.nextInt();
		int l = sc.nextInt();
		int count = v0;
		int i = 1;
		while (count < c) {
			 count += Math.min(v1, v0 + i * a) - l;
			 i++;		
			
		}
		System.out.println(i);

	}

}
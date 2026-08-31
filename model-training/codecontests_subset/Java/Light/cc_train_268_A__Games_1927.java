import java.util.Scanner;


public class Games {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a1 = new int [n];
		int [] a2 = new int [n];
		for (int i = 0; i < a2.length; i++) {
			a1[i] = sc.nextInt();
			a2[i] = sc.nextInt();
		}
		int c = 0;
		for (int i = 0; i < a2.length; i++) 
			for (int j = 0; j < a2.length; j++) 
				if(a1[i] == a2[j])
					c++;
		System.out.println(c);
	}
}

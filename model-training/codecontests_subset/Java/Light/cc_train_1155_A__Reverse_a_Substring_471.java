import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		String b = scan.next();

		for (int i = 1; i< a; i++){
			if (b.charAt(i) < b.charAt(i-1)){
				System.out.println("YES");
			System.out.println((i) + " " + (i+1));
			return;
			} 
		}
		
		System.out.println("NO");

	}

}

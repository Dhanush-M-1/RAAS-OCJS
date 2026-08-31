import java.util.Scanner;

public class NP {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int l = scan.nextInt();
		int r = scan.nextInt();

		if(l==r){
			System.out.println(l);
		}
		else {
			System.out.println(2);
		}
	}
}

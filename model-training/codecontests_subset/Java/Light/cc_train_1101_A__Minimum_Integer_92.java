
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//inputs
		int t = input.nextInt();
		for(int i = 0 ; i < t ; i++){
		int l = input.nextInt();
		int r = input.nextInt();
		int d = input.nextInt();
		
			System.out.println(d < l || d > r ? d : r + (d - r % d));
			
		}
		
	}
}

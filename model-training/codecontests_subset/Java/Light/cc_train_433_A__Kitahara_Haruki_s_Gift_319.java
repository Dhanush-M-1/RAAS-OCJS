import java.util.Arrays;
import java.util.Scanner;


public class App {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int count = 0;
		for(int i = 0; i<n; i++) {
			int k = sc.nextInt();
			if(k == 200)count++;
		}
		
		if((n%2 == 1 && count%2 == 0) || (n%2 == 0 && count%2 == 1) || n == 1 || (count%2 == 1 && count == n))System.out.println("NO");
		else System.out.println("YES");
	}

}

import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner in = new java.util.Scanner(System.in);
		int n = in.nextInt();
		int sum = -n;
		for(int i=0; i<n; i++) {
			sum += in.nextInt();
		}
		
		
		System.out.println(sum);
		in.close();
	}
}
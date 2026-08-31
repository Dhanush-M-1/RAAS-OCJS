import java.util.Scanner;

public class problem {

	static Scanner input = new Scanner(System.in);

	static int n = input.nextInt();
	static int c = input.nextInt();
	static int [] x = new int [n];
	static int [] diff = new int [n-1];
	public static void main(String[] args) {
		
		for (int i = 0; i < n ; i++){
			x[i] = input.nextInt();
		}
		
		for (int i =0 ; i < n-1;i++){
			diff[i] = x[i]-x[i+1];
		}
		
		int max = diff[0];
		
		for (int i = 0; i < n-1 ; i++){
			if (diff[i]>max){
				max = diff[i];
			}
		}
		if (max-c>0){
			System.out.println(max-c);
		}
		else {
			System.out.println(0);
		}

		
	}
}

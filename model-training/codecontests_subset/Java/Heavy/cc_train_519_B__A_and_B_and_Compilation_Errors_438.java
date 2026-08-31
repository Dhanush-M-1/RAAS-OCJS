import java.util.Scanner;

public class ABCompilationError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		scan.nextLine();
		double sum_init = 0;
		for(int i = 0 ; i < n; i++) {
			sum_init += scan.nextDouble();
		}
		
		scan.nextLine();
		double sum_secondary = 0;
		for(int i = 0 ; i < n-1; i++) {
			sum_secondary += scan.nextDouble();
		}
		
		scan.nextLine();
		double sum_third = 0;
		for(int i = 0 ; i < n-2; i++) {
			sum_third += scan.nextDouble();
		}
		
		System.out.println(Math.round(sum_init - sum_secondary));
		System.out.print(Math.round(sum_secondary-sum_third));
	}

}

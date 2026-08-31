import java.util.Scanner;


public class Main{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cnt = Integer.parseInt(s.nextLine());
		int result = 0;
		for(int i=0 ; i<cnt ; i++) {
			int number = Integer.parseInt(s.nextLine());
			result += solve(number);
		}
		System.out.println(result);
	}

	public static int solve(int number) {
		if(number == 2) {
			return 1;
		}
		if(number % 2 == 0) {
			return 0;
		}
		for(int i=3 ; i<=Math.sqrt(number) ; i+=2){
			if(number % i == 0) {
				return 0;
			}
		}
		return 1;
	}

}
import java.util.Scanner;

public class Main{
	public static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0;i < n; i++){
			int num = sc.nextInt();
			solve(num);
		}

		System.out.println(count);

	}

	public static void solve(int num){
		if(num == 1){
			return;
		}
		else if(num == 2){
			count++;
			return;
		}
		else if(num % 2 == 0){
			return;
		}
		else{
			for(int i = 3;i <= Math.sqrt(num); i++){
				if(num % i == 0){
					return;
				}
			}
		}
		count++;
	}

}
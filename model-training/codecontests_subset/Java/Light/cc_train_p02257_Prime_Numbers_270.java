import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		run();
	}

	static boolean isPrime(int x){
		if(x == 2){
			return true;
		}else if(x < 2 || x % 2 == 0){
			return false;
		}
		int i = 3;
		while(i <= Math.sqrt(x)){
			if(x % i == 0){
				return false;
			}
			i= i + 2;
		}
		return true;
	}
	
	static void run(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x;
		int count;
		count = 0;
		boolean judge;
		for(int i = 0; i < n; i++){
			x = scan.nextInt();
			judge = isPrime(x);
			if(judge) count++;
			judge = false;
		}
		System.out.println(count);
	}
}
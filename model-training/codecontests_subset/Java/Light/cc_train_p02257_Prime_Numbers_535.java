import java.util.Scanner;

class Main {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int x;
		int ans = 0;
		
		for(int i = 0; i < n; i++){
			x = scan.nextInt();
			if(isprime(x))ans++;
		}
		System.out.println(ans);
	}
	
	public static boolean isprime(int x){
		if(x == 2){
			return true;
		}
		
		if(x < 2 || x % 2 == 0){
			return false;
		}
		
		int i = 3;
		while(i <= Math.sqrt(x)){
			if(x % i == 0){
				return false;
			}
			i += 2;
		}
		
		return true;
	}
}
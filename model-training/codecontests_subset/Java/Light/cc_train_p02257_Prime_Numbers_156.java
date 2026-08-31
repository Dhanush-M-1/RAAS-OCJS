import java.util.Scanner;
class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int count = 0;
		for(int i = 0; i < N; i++){
			count += (isPrime(scan.nextInt()) ? 1 : 0);
		}
		System.out.println(count);
	}
	public static boolean isPrime(int a){
		for(int i = 2; i * i <= a; i++){
			if(a % i == 0){
				return false;
			}
		}
		return true;
	}
}
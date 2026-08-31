import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		while(n-->0) {
			int num = sc.nextInt();
			if(isPrime(num)) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static boolean isPrime(int num){
		for(int i=2;i*i<=num;i++)
			if(num%i==0) return false;
		return true;
	}
}

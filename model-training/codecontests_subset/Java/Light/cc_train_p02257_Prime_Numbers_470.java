
import java.util.Scanner;

public class Main {

	//static boolean isprime[n];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cnt=0;
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			int tmp=scanner.nextInt();
			if(isprime(tmp)){
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static boolean isprime(int x) {
		// TODO Auto-generated method stub
		if(x==2) return true;
		if(x<2||(x%2==0)) return false;
		for(int i=3;i<=Math.sqrt(x);i=i+2){
			if(x%i==0)
				return false;
		}
		return true;
	}

}


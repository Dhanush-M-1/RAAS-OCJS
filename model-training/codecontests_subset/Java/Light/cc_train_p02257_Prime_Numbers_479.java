import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ans=0;
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			if(isPrime(x)) ans++;
		}
		System.out.println(ans);
	}
	static boolean isPrime(int x){
		for(int j=2;j<=Math.sqrt(x);j++){
			if(x%j==0){
				return false;
			}
		}
		return true;
	}

}
import java.util.Scanner;

class Main {
	
	static boolean isPrime(int x){
		
		for(int i=2;i<=Math.sqrt(x);i++)
			if(x%i==0)return false;
		
		return true;
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int cnt=0;
		for(int i=0;i<n;i++){
			int x=scan.nextInt();
			if(isPrime(x))
				cnt++;
		}
		
		System.out.println(cnt);
		
	}
}

import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt=0;
		for(int i=0; i<N; i++){
			if(isPrime(sc.nextInt())) cnt++;
		}
		System.out.println(cnt);
	}
	static boolean isPrime(int x){
		int i, s;
		if(x==2){
			return true;
		}
		if(x<2 || x%2==0){
			return false;
		}
		i = 3;
		s = (int)Math.sqrt(x);
		while(i<=s){
			if(x%i==0){
				return false;
			}
			i += 2;
		}
		return true;
	}
}
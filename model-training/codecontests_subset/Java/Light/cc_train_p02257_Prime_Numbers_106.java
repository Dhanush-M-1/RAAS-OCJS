import java.util.Scanner;
class Main {
	public static void main(String[] args){
		final int Number=100;
		try(Scanner sc = new Scanner(System.in)){
			int N = Integer.parseInt(sc.next());
			int[] p=new int[N];
			for(int i=0;i<N;i++) p[i] = Integer.parseInt(sc.next());
			int cnt=0;
			for(int i=0;i<N;i++){
				if(isPrime(p[i])){
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	public static boolean isPrime(int p){
		boolean ans=true;
		for(int i=2;i*i<=p;i++){
			ans=ans&&(p%i!=0);
		}
		return ans;
	}
}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		
		int a;
		int num=0;
		for(int i=0;i<N;i++){
			a = Integer.parseInt(sc.next());
			if(isPrime(a)) num++;
		}
		System.out.println(num);

	}
	
	public static boolean isPrime(int a){
		boolean warenai=true;
		for(int i=2;i<=Math.sqrt(a);i++){
			if(a%i==0) {
				warenai=false;
				break;
			}
		}
		return warenai;
	}

}
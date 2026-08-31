import java.util.Scanner;
public class Main {
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = 0;
		
		for(int i=0; i < n; i++){
			if(PNcheck(sc.nextInt())) c++;
		}
		System.out.println(c);
	}
	
	static boolean PNcheck(int n){
		if(n == 2) return true;
		if((n % 2) == 0) return false;
		
		for(int i=3; i*i <= n; i = i+2){
			if((n % i) == 0) return false;
		}
		return true;
	}
}
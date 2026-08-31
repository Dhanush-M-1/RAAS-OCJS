
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =0;
		int size = sc.nextInt();//size of the array
		for(int i=0;i<size; i++) {
			int p = sc.nextInt();
			Boolean x = findPrime(p);
			//System.out.println(x);
			if(x == true) {
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
	
	public static boolean findPrime(int B) {
		if(B==0||B==1) {
			return false;
		}
		else if(B==2||B==3||B==5||B==7) {
			return true;
		}
		for(int j=2; j<= Math.sqrt(B);j++) {
			if(B%j == 0){
				return false;
			}
		}
		return true;
	}
}


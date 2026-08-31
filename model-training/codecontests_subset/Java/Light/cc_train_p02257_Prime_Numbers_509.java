import java.util.*;

public class Main{
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		int n = scan.nextInt();
		int[] arr = new int[n];
		int count = 0;
		for(int i = 0; i < n; i++){
			arr[i] = scan.nextInt();
			if(isPrime(arr[i])){
				count++;
			}
		}
		System.out.printf("%d\n", count);
	}

	public static boolean isPrime(int x){
		if(x == 2)
			return true;
		if(x < 2 || x % 2 == 0)
			return false;
		int i = 3;
		while(i <= Math.sqrt(x)){
			if(x % i == 0)
				return false;
			i += 2;
		}
		return true;
	}
}
import java.util.Scanner;
public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int i, j, k;
		int n = sc.nextInt();
		int a[] = new int[n];
		int count = 0;
		
		for(i = 0; i < n; i++){
			a[i] = sc.nextInt();
			if(prime(a[i]) == 1) count++;
		}
		System.out.println(count);
		
		
	}
	
	public static int prime(int x){
		if(x == 2) return 1;
		if(x <= 1 || x % 2 == 0) return 0;
		int i = 3;
		
		while( i <= Math.sqrt(x)){
			if(x % i == 0) return 0;
			i = i + 2;
		}
		return 1;
	}
}

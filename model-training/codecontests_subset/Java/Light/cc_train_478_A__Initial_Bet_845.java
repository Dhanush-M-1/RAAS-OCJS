import java.util.*;

public class Main{
	static int[] a = new int[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < 5; i++)
			a[i] = sc.nextInt();

		for(int b = 1; b <= 100; b++){
			if(check(b)){
				System.out.println(b);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}

	static boolean check(int b){
		int t = 0;
		for(int i = 0; i < 5; i++){
			if(a[i] > b)
				t += a[i] - b;
			if(a[i] < b)
				t -= b - a[i]; 
		}

		return t == 0;	
	}
}
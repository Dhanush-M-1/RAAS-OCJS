import java.io.File;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
public class BookIsGreat {
	
	public static void main(String args[]) throws Exception{
		int n, m, c,x = 0, k = 1;
		int res = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int books[] = new int[n];
		int genres[] = new int[m];
		
		for (int i = 0; i < n; i++){
			books[i] = sc.nextInt();
			genres[books[i]-1]++;
		}
		for (int i = 0; i < m;i++){
			k = n - genres[i] - x;
			res += genres[i] * k;
			x+=genres[i];
		}
		System.out.println(res);
		
	}
	
}

	

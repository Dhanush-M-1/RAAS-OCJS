import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class theBestGift {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		Integer books[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			books[i] = sc.nextInt();
		}

		Arrays.sort(books);
		int numWays = 0;
		int numDistInt = 1;

		for (int i = 0; i < (n-1); i++) {
			if (books[i] != books[i + 1])
				numDistInt++;
		}

		int distInt[] = new int[numDistInt];

		for (int i = 0; i < n; i++) {
			distInt[(books[i]-1)]++;
		}
		
		
		int c = 0;
		for (int i = 0;i<distInt.length;i++) {
			c += distInt[i];
		}
		/*
		for (int i=0;i<books.length;i++) {
			if(books[i] != books[books.length-1]){
				c -= books[i];
				numWays += c;
			}
		}
		*/
		
		for (int i = 0;i<distInt.length-1;i++) {
			c -= distInt[i];
			numWays += distInt[i]*c;
		}
		
		System.out.println(numWays);
	}
}

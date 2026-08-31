import java.util.Scanner;
public class TheBestGift {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfBooks = in.nextInt();
		int numOfGenres = in.nextInt();
		
		int[] books = new int[numOfBooks];
		for (int i = 0; i < numOfBooks; i++)
			books[i] = in.nextInt();
		
		int[] a = new int[numOfGenres];
		for (int i = 0; i < numOfBooks; i++)
			a[books[i]-1]++;
		
		int c = numOfBooks - 1;
		int sum = 0;
		while (c != 0) {
			sum = sum + c;
			c--;
		}
		for (int i = 0; i < a.length; i++) {
			sum = sum - pairs(a[i]);
		}
		System.out.println(sum);
		/*
		int count = 0;
		for (int i = 0; i < books.length-1; i++) {
			for (int j = i+1; j < books.length; j++) {
				if (books[i] != books[j])
					count++;
			}
		}
		System.out.println(count); */
	}
	public static int pairs(int n) {
		int s = 0;
		n--;
		while (n != 0) {
			s = s + n;
			n--;
		}
		return s;
	}
}

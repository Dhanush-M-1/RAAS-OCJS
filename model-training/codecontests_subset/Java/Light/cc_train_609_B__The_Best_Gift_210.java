import java.util.Scanner;


public class TheBestGift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// number of books
		int m = sc.nextInt();	// number of genres
		
		int[] book = new int[n];
		
		for(int i=0; i<n; i++){
			book[i] = sc.nextInt();
		}
		
		int[] cnt = new int[m+1];
		cnt[0] = -1;
		
		for(int i=0; i<book.length; i++){
			cnt[book[i]]++;
		}
		
		int result=0;
		for(int i=0; i<book.length-1; i++){
			result += (n-i)-cnt[book[i]];
			cnt[book[i]]--;
		}
		
		System.out.println(result);
	}

}

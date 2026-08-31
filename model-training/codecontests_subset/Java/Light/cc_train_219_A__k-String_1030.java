import java.util.ArrayList;
import java.util.Scanner;

public class kString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		String s = scan.next();
		int[] arr = new int[26];
		for (int i = 0 ; i < s.length() ; i++) {
			arr[s.charAt(i) - 'a']++;
		}
		
		int count = 0;
		for (int i = 0 ; i < arr.length ; i++)
			if (arr[i] > 0)
				count++;

			if (!check(arr, k))
				System.out.println(-1);
			else {
				for (int i = 0 ; i < k ; i++ ) {
					for (int j = 0 ; j < arr.length ; j++) {
						for (int a = 0 ; a < arr[j] / k ; a++)
							System.out.print((char)(j+'a'));
					}
				}
			
		}
		 

		
	}
	
	static boolean check(int[] arr, int k) {
		for (int i = 0 ; i < arr.length ; i++) 
			if (arr[i] % k != 0)
				return false;
		return true;
	}

}

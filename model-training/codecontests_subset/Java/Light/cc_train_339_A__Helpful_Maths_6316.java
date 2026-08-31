import java.util.Arrays;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/339/A
public class SortingBasedAddition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		//String resStr = "";
		int arr[] = new int[str.length()/2+1];
		int ascii, j=0;

		for (int i = 0 ; i < str.length(); i++){
			ascii = str.charAt(i) ;
			//System.out.println(ascii);
			if (ascii >= 48 && ascii <= 57 ){
				arr[j++] = Character.getNumericValue(str.charAt(i));			
			}
		}
		Arrays.sort(arr);
		String rev ="";
		for(int i = 0; i < arr.length; i++){
			//			System.out.println(arr.length);
			//			System.out.println(arr[i]);
			rev += arr[i] + "+";
		}
		rev = rev.substring(0, rev.length()-1);
		System.out.println(rev);
		sc.close();
	}

}

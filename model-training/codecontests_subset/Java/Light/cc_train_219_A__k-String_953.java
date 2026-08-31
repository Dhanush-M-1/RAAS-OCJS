import java.util.*;
import java.io.*;
public class kStr {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String res = "";
		int k = sc.nextInt();
		String s = sc.next();
		int m = s.length();
		int arr[] = new int[26];
		for(int i = 0; i < m; i++) {
			arr[s.charAt(i) - 'a']++;
		}
		for(int i = 0; i < 26; i++) {
			if(arr[i] % k != 0) {
				System.out.println("-1");
				return;
			}
		}
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < arr[i]/k; j++) {
				res = res + (char) (i + 97);
			}
		}
		for(int i = 0; i < k;  i++) {
			System.out.print(res);
		}
	}
}
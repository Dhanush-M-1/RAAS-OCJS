import java.util.*;
public class Test {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String temp = sc.nextLine();
		String s = sc.nextLine();
		int[] arr = new int[26];
		for (int i=0; i<s.length(); i++) {
			arr[s.charAt(i)-'a']++;
		}
		
		String part = "";
		for (int i=0; i<26; i++) {
			if (arr[i]%k != 0) {
				System.out.println(-1);
				System.exit(0);
			} else {
				arr[i] = arr[i]/k;
				for (int j=0; j<arr[i]; j++) {
					char c = (char) (i + 'a');
					part += c;
				}
			}
		}
		
		for (int i=0; i<k; i++) {
			System.out.print(part);
		}
	}
}
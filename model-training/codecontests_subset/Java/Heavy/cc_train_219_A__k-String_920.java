import java.util.Scanner;

public class laddering {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int k = sc.nextInt();
		
		sc.nextLine();
		
		String str = sc.nextLine();
		
		int[] amt = new int[26];
		
		if (k == 1) {
			System.out.println(str);
			return;
		}
		
		for (int i =0; i < str.length(); i++) {
			amt[str.charAt(i)-'a']++;
		}
		String b = "";
		for (int i =0; i < 26; i++) {
			if (amt[i]%k == 0) {
				// good
				for (int j =0; j < amt[i]/k; j++) {
					b +=  (char)(i+'a');
				}
			}else {
				System.out.println(-1);
				return;
			}
		}
		String out = "";
		for (int i = 0; i < k; i++) {
			out += b;
		}
		
		System.out.println(out);
			
	}

}

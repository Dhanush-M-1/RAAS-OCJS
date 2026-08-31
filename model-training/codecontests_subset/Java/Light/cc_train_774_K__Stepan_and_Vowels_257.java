import java.util.*;

public class Sol{
	public static void main(String[] argc){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String ss = sc.nextLine();
		ss = sc.nextLine();
		char[] s = ss.toCharArray();
		//System.out.format("%s", s);
		
		char c[] = new char[n];
		int q[] = new int[n];
		int cnt = 1;
		c[0] = s[0];
		q[0] = 1;
		for (int i = 1; i < n; i++) {
			if (s[i] != s[i - 1]) {
				c[cnt] = s[i];
				q[cnt] = 0;
				cnt++;
			}
			q[cnt - 1] += 1;
		}
		for (int i = 0; i < cnt; i++) {
			if (!((c[i] == 'e' || c[i] == 'o') && q[i] == 2) && 
				(c[i] == 'e' || c[i] == 'a' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u' || c[i] == 'y')) {
				System.out.format("%c", c[i]);
			}
			else {
				for (int j = 0; j < q[i]; j += 1)
					System.out.format("%c", c[i]);
			}
		}
	}
	
	
	
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] s = new String[n];
		for(int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		int[] cnt = new int[4];
		for(int i = 0; i < 4; i++) {
			cnt[i] = 0;
		}
		
		for(int i = 0; i < n; i++) {
			if(s[i].charAt(0) == 'A') {
				cnt[0]++;
			}
			if(s[i].charAt(0) == 'W'){
				cnt[1]++;
			}
			if(s[i].charAt(0) == 'T') {
				cnt[2]++;
			}
			if(s[i].charAt(0) == 'R') {
				cnt[3]++;
			}
		}
		System.out.println("AC x "+cnt[0]+"\n"+"WA x "+cnt[1]+"\nTLE x "+cnt[2]+"\nRE x "+cnt[3]);
	}
}

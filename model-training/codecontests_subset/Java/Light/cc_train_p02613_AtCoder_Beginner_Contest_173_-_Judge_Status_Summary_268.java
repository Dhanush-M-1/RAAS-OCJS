import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] s = new String[n];
		int[] c = {0,0,0,0};
		String[] j = {"AC", "WA", "TLE", "RE"};
		
		for(int i=0;i<n;i++){
			s[i] = scan.next();
			if(s[i].equals(j[0])) {
				c[0]++;
			}else if(s[i].equals(j[1])) {
				c[1]++;
			}else if(s[i].equals(j[2])) {
				c[2]++;
			}else {
				c[3]++;
			}
		}
		
		for(int i=0;i<4;i++) {
			System.out.println(j[i]+" x "+c[i]);
		}
	}

}

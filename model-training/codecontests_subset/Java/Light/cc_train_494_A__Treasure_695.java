import java.util.ArrayList;
import java.util.Scanner;


public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int want = 0;
		int sharp = 0;
		int check = 0;
		int lastSharp = -1;
		ArrayList<Integer> out = new ArrayList<Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				want++;
				check++;
			} else if(s.charAt(i) == ')') {
				want--;
				check--;
			} else if(s.charAt(i) == '#') {
				sharp++;
				check--;
				lastSharp = i;
			}
			if(check < 0) {
				System.out.println(-1);
				return;
			}
		}
		
		int a[] = new int[sharp];
		for(int i = 0; i < sharp - 1; i++) {
			a[i] = 1;
			want--;
		}
		a[sharp - 1] = want;
		
		int bal = 0;
		int cnt = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				bal++;
			} else if(s.charAt(i) == ')') {
				bal--;
			} else if(s.charAt(i) == '#') {
				bal -= a[cnt];
				cnt++;
			}
			
			if(bal < 0) {
				System.out.println(-1);
				return;
			}
		}
		
		for(int v: a) {
			System.out.println(v);
		}
		
	}
}

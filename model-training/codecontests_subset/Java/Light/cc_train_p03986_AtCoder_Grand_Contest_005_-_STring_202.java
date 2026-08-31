import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] x = sc.next().toCharArray();
		int N = x.length;
		
		int t=0,s=0;
		for(int i=0; i<N; i++) {
			if(x[i]=='T') {
				if(s>0) {
					s--;
				} else {
					t++;
				}
			} else {
				s++;
			}
		}
		
		System.out.println(t+s);
		sc.close();
	}
}

import java.util.*;

public class Rem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int x =sc.nextInt();
		int y =sc.nextInt();
		if(y>=0 && x>y && n>x && n<=200000) {
			String s = sc.next();
			int count = 0;
			if(s.startsWith("1")) {
				
					if(s.charAt(n-y-1)=='0') {
						count++;
						}
				
				if(y>=1) {
					for(int i=n-y;i<n;i++) {
						if(s.charAt(i)=='1') {count++;}
					}
					
				}
				if((n-x)<(n-y-1)) {
					for(int j=n-x;j<n-y-1;j++) {
						if(s.charAt(j)=='1') {count++;}
					}
				}
			}
			System.out.println(count);
		}

	}

}

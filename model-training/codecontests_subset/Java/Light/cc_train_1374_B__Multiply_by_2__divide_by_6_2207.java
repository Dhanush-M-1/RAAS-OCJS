import java.util.*;
public class P653Div3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int c2 = 0, c3 = 0;
			while(n%2 == 0) {
				n = n/2;
				c2++;
			}
			while(n%3 == 0) {
				n = n/3;
				c3++;
			}
			if(n == 1 && c3>=c2) {
				System.out.println(2*c3 - c2);
			}
			else
				System.out.println(-1);
		}
	}

}

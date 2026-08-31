import java.util.ArrayList;
import java.util.Scanner;

public class cf571b {
	static int x,a2,a3,a5;
	static int y,b2,b3,b5;
//	ArrayList<Integer> fac= new ArrayList<>();
	static void facX() {
		while (x%2==0) {
			a2++;
			x/=2;
		}
		while (x%3==0) {
			a3++;
			x/=3;
		}
		while(x%5==0) {
			a5++;
			x/=5;
		}	
	}
	static void facY() {
		while (y%2==0) {
			b2++;
			y/=2;
		}
		while (y%3==0) {
			b3++;
			y/=3;
		}
		while(y%5==0) {
			b5++;
			y/=5;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x= sc.nextInt();
		y= sc.nextInt();
		sc.close();
		facX();
		facY();
//		int res = method(a,b);
		if (x!=y) {
			System.out.print(-1);
			return;
		}
		System.out.print(Math.abs(a2-b2)+Math.abs(a3-b3)+Math.abs(a5-b5));
	}
}

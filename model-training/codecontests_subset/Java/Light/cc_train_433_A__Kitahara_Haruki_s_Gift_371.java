import java.util.*;

public class solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int h=0,th=0;
		for(int i=0;i<n;i++) {
			if(sc.nextInt()==100) {
				h++;
			}
			else {
				th++;
			}
		}
		if(h%2==0 && th%2==0) {
			System.out.println("YES");
		}
		else if(h%2!=0 && th%2!=0) {
			System.out.println("NO");
		}
		else if(h%2==0 && th%2!=0) {
			if(h==0) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}
		else {
			System.out.println("NO");
		}
	}
}
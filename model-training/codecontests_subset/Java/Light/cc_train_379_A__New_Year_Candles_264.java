import java.util.*;
public class vasyasocks {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();int m=sc.nextInt();
		int days=n;
		while(n/m!=0) {
			int q=n/m;
			int r=n%m;
			days=days+q;
			n=q+r;
		}
		System.out.print(days);sc.close();
	}

}

import java.util.*;
public class Cforces4211 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m1 = in.nextInt();
		int m2 = in.nextInt();
		int a = in.nextInt();
		int l = in.nextInt();
		int d = 0;
		long s=0;
		int r = 0;
		int l1=0;
		//System.out.print(n+" "+m1+" "+m2+" "+a+" "+l);
		while(s<n){
			int x = m1+(a*r);
			if(x>m2)x=m2;
			s=s+x-l1;
			//System.out.println("s: "+s);
			l1=l;
			r++;
			d++;
		}
		System.out.println(d);
	}
}

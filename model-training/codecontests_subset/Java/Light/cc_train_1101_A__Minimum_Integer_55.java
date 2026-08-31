import java.util.*;
public class Cf1101A {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int l,r,d,t,p;
		t=sc.nextInt();
		while(t>0){
			l=sc.nextInt();
			r=sc.nextInt();
			d=sc.nextInt();
			if(l>d)
				System.out.println(d);
			else {
				p=(r/d)*d+d;
				System.out.println(p);
			}
			t--;
		}
		sc.close();
	}

}

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		int c, d, e;
		while(sc.hasNext()){
			String[] s = sc.next().split(",");
			c = Integer.valueOf(s[0]);
			d = Integer.valueOf(s[1]);
			e = Integer.valueOf(s[2]);
			if(c*c + d*d == e*e)a++;
			if(c==d)b++;
		}
		System.out.println(a);
		System.out.println(b);
	}	
}
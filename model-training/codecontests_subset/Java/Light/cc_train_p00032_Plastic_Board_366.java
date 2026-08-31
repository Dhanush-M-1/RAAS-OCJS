import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		int b = 0;
		int c, d, e;
		while(sc.hasNext()){
			String s = sc.next();
			int i=0;
			int start=0;
			while(s.substring(i,i+1).compareTo(",")!=0)i++;
			c = Integer.valueOf(s.substring(start,i));
			i++;
			start=i;
			while(s.substring(i,i+1).compareTo(",")!=0)i++;
			d = Integer.valueOf(s.substring(start,i));
			e = Integer.valueOf(s.substring(i+1,s.length()));
			if(c*c + d*d == e*e)a++;
			if(c==d)b++;
		}
		System.out.println(a);
		System.out.println(b);
		
	}	
}
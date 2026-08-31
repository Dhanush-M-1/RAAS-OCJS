import java.util.*;


public class A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r1 = s.nextInt(),r2=s.nextInt(),
			c1=s.nextInt(),c2=s.nextInt(),
			d1=s.nextInt(),d2=s.nextInt();
		
		for(int a=1;a<=9;a++)
			for(int b=1;b<=9;b++)
				for(int c=1;c<=9;c++)
					for(int d=1;d<=9;d++){
						if(ok(a,b,c,d,r1,r2,c1,c2,d1,d2)) {
							System.out.println(a + " " + b);
							System.out.println(c + " " + d);
							return;
							}
					}
		System.out.println("-1");
	}
	static boolean ok(int a,int b,int c,int d,int r1,int r2,int c1,int c2,int d1,int d2){
		Set<Integer> s = new HashSet<Integer>();
		s.add(a);s.add(b);s.add(c);s.add(d);
		if(s.size() == 4 && (r1==a+b && r2==c+d && d1==a+d && d2==b+c && a+c==c1 && c2==b+d)) return true;
		return false;
	}
}

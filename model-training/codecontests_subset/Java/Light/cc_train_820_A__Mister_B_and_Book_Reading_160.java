import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		new A();
	}

	int c,v0,v1,a,l;
	
	A() {
		
		Scanner in = new Scanner(System.in);
		
		c = in.nextInt();
		v0 = in.nextInt();
		v1 = in.nextInt();
		a = in.nextInt();
		l = in.nextInt();
		
		c -= v0;
		
		int i;
		for(i=1;c>0;i++){
			c -= Math.min(v0+i*a,v1)-l;
			//System.out.println(v0+i*a);
		}
		
		System.out.println(i);
			
		in.close();

	}
	
}

/*

5 5 10 5 4

12 4 12 4 1

15 1 100 0 0

12 4 12 4 0

 */












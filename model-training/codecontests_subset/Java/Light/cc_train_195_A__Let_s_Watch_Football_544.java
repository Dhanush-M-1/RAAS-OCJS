import java.util.Scanner;


public class A {

	public int solve (int a , int b , int c) {
		int t0 = 0;
		if( a> b ){
			int tmp = ( a-b)*c;
			t0 = tmp / b;
			if( tmp % b != 0) {
				t0 ++ ;
			}
		}
		return t0;
	}
	
	public static void main (String [] args){
		A solution = new A();
		Scanner cin = new Scanner(System.in);
		while ( cin.hasNext()) {
			int a  = cin.nextInt();
			int b = cin.nextInt();
			int c = cin.nextInt();
			System.out.println(solution.solve(a, b, c));
		}
		cin.close();
	}
}

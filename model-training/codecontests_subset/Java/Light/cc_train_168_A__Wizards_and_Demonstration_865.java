import java.util.Scanner;

public class A113 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		double tot = Math.ceil(((double)(y*n))/(double)100);
		if((tot - x)>=0){
			int e = (int) (tot-x);
			System.out.println(e);
		} else
			System.out.println(0);

	}
}

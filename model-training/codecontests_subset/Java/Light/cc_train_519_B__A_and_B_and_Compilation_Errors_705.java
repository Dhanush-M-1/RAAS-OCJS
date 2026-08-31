import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P519B {

	public static Scanner sc = new Scanner(System.in);
	public static int x, y, count = 0;
	public static List<Integer> array= new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int n =sc.nextInt();
		for (int i=0;i<n;i++) {
			count += sc.nextInt();
		}
		for (int i=0;i<n-1;i++) {
			x += sc.nextInt();
		}
		for (int i=0;i<n-2;i++) {
			y += sc.nextInt();
		}
		y = x - y;
		x = count - x;
		
		System.out.println(x);
		System.out.println(y);
		
	}

}

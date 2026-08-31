import java.util.Scanner;
import java.lang.Math; 

public class Main {

	public static boolean solution(int x) {
		for (int j = 2; j<=(int)Math.sqrt(x); j++) {
			if (x%j==0 && x != j){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n]; 
		for (int i = 0; i<n; i++) {
			x[i] = in.nextInt();
		}
		int count = 0;
		for (int i = 0; i<x.length; i++) {
			boolean out = solution(x[i]);
			if (out) {
				count += 1;
			}
		}
		System.out.println(count);
	}
}

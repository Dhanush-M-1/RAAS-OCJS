import java.util.Scanner;
import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList <Integer> a = new ArrayList<Integer> ();
		ArrayList <Integer> count = new ArrayList<Integer> ();
		for (int i = 0; i < n; i++) 
			a.add(sc.nextInt());
		for (int i = 0; i <= m; i++) 
			count.add(0);
		long answer = 0;
		for (int x: a) {
			count.set(x, count.get(x) + 1);
		}
		for (int x: count) {
			answer += (long)(n - x) * x;
		}
		System.out.print(answer/2);
	}
}
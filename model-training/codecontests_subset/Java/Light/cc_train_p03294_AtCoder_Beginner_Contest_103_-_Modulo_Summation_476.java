//package reedeka;
import java.util.*;
import java.lang.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n, x;
		n = sc.nextInt();
		int i;
		long sum = 0;
		for(i=0; i<n; i++) {
			x = sc.nextInt();
			sum += (x-1);
		}
		System.out.println(sum);
	}
}

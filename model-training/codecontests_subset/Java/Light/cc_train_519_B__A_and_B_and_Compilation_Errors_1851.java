import java.io.*;
import java.util.*;

public class P_519B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = 0, sum1 = 0, sum2 = 0;
		for(int i = 0; i < n; i++) sum += scan.nextInt();
		for(int i = 0; i < n - 1; i++) sum1 += scan.nextInt();
		for(int i = 0; i < n - 2; i++) sum2 += scan.nextInt();	
		System.out.println(sum - sum1);
		System.out.println(sum1 - sum2);
	}
}
import java.util.*;
import java.io.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int a = sc.nextInt(), b = sc.nextInt(), n = sc.nextInt();
			if(n % 3 == 0) {
				System.out.println(a);
			} else if(n % 3 == 1) {
				System.out.println(b);
			} else if(n % 3 == 2) {
				System.out.println(a ^ b);
			}
		}
	}
}

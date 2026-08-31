import java.util.*;
import java.io.*;

public class Div2_338A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), m = sc.nextInt();
		boolean[] array = new boolean[m];
		for(int i = 0; i < n; i++) {
			int k = sc.nextInt();
			for(int j = 0; j < k; j++)
				array[sc.nextInt() - 1] = true;
		}
		
		for(int i = 0; i < m; i++)
			if(!array[i]) {
				System.out.println("NO");
				return;
			}
		
		System.out.println("YES");
	}
}

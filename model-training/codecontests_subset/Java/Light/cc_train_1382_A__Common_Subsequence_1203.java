import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.lang.Math;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i =0; i<t;i++) {
			int n = sc.nextInt(), m = sc.nextInt();
			boolean[] numbers = new boolean[10001];
			for(int j = 0; j<n; j++)
				numbers[sc.nextInt()] = true;
			boolean possible = false;
			for(int j = 0; j<m;j++) {
				int x = sc.nextInt();
				if(!possible && numbers[x]) {
					System.out.println("YES");
					System.out.println(1 + " " + x);
					possible = true;
				}
			}
			if(!possible)
				System.out.println("NO");
		}
		sc.close();
	}
}
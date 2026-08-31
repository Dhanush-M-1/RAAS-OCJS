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
		for(int i = 0; i <t; i++) {
			int n = sc.nextInt(), plays = 0, clears = 0;
			boolean possible = true;
			for(int j = 0; j<n; j++) {
				int x = sc.nextInt(), y = sc.nextInt();
				if(x - plays < 0 || y - clears < 0 ||x - plays < y - clears)
					possible = false;
				plays = x;
				clears = y;
			}
			if(possible)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
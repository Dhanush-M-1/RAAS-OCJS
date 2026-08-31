import java.util.*;
import java.io.*;

public class Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] ha = new int[n][2];
		for (int i = 0; i < n; i++) {
			ha[i][0] = in.nextInt();
			ha[i][1] = in.nextInt();
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == i) continue;
				if (ha[i][0] == ha[j][1]) count++;
			}
		}
		System.out.println(count);
		
		
	}
	
}

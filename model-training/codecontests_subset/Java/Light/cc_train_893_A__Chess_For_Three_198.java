import java.util.*;
import java.io.*;

public class CF893A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] p = {1, 2, 3};
		boolean invalid = false;
		for(int i = 0 ; i < n ; i++) {
			int victor = scan.nextInt();
			if(victor == p[0])
				swap(1, 2, p);
			if(victor == p[1])
				swap(0, 2, p);
			if(victor == p[2])
				invalid = true;
		}
		if(invalid) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
	static void swap(int i, int j, int[] players) {
		int temp = players[i];
		players[i] = players[j];
		players[j] = temp;
	}
}

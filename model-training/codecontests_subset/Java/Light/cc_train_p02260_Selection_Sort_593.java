import java.util.*;
import java.io.*;

class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<n; i++) list.add(sc.nextInt());
		int ans = 0;
		
		for (int i=0; i<n; i++) {
			int min = i;
			boolean b = false;
			for (int j=i; j<n; j++) {
				if (list.get(j) < list.get(min)) {
					min = j;
					b = true;
				}
			}
			
			if (b == true) ans++;
			
			Collections.swap(list, i, min);
			
		}
		
		for (int i=0; i<n; i++) {
			System.out.print((i==0?"":" ")+list.get(i));
		}
		System.out.println();
		System.out.println(ans);
		
	}
}


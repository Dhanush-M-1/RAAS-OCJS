
import static java.lang.Integer.parseInt;

import java.util.Scanner;

public class G {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		String s = "";
		int count = 1;
		int[] arr = new int[100];
		int k = 0;
		arr[k++] = 1;
		while (!s.contains("=")) {
			s = sc.next();
			if (s.contains("+")) {
				count++;
				arr[k++] = 1;
			}
			if (s.contains("-")) {
				count--;
				arr[k++] = -1;
			}
		}
		int n = parseInt(sc.next());
		for (int i = 0; i < k; i++) {
			if (arr[i] > 0) {
				while (count < n && arr[i] < n) {
					arr[i]++;
					count++;
				}
				
			} else {
				while (count > n && arr[i] < 0 && arr[i] > -n) {
					arr[i]--;
					count--;
				}
				
			}
		}
		if (count != n) {
			System.out.println("Impossible");
		} else {
			System.out.println("Possible");
			for (int i = 0; i < k; i++) {
				if (i > 0) {
					System.out.print(((arr[i] < 0)? "- " : "+ ") + Math.abs(arr[i]) + " ");
				} else {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.print("= " + n);
		}
	}

}

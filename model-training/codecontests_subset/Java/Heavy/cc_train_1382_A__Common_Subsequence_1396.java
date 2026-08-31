import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i = 0; i < t; i++) {
			int length1 = s.nextInt();
			int length2 = s.nextInt();
			int[] arr1 = new int[length1];
			int[] arr2 = new int[length2];
			for(int j = 0; j < length1; j++) {
				arr1[j] = s.nextInt();
			}
			for(int j = 0; j < length2; j++) {
				arr2[j] = s.nextInt();
			}
			int ans = 0;
			for(int j = 0; j < length1; j++) { 
				for(int k = 0; k < length2; k++) {
					if(arr1[j] == arr2[k]) {
						ans = arr1[j];
						break;
					}
				}
			}
			if(ans != 0) {
				System.out.println("YES");
				System.out.println("1 " + ans);
			} else {
				System.out.println("NO");
			}
		}
	}

}

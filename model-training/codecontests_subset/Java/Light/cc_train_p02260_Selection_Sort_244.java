
import java.util.*;
class Main { 
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int aryLen = scan.nextInt();
		int[] ary = new int[aryLen];
		int min = 0;
		int count = 0;
		int point = 0;
		for(int i = 0 ; i < aryLen; i++ ) {
			ary[i] = scan.nextInt();
		}

		for(int n = 0; n < aryLen; n++) {
			min = ary[n];
			for(int j = n + 1; j < aryLen; j++) {
				if(ary[j] < min) {
					min = ary[j];
					point = j;
				}
			}
			if(min != ary[n]) {
				count++;
				ary[point] = ary[n];
				ary[n] = min;
			}
		}
		for(int k = 0; k < aryLen; k++) {
			System.out.print(ary[k]);
			if(k != aryLen-1 ) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}
		System.out.println(count);
	}
}

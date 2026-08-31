import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] ar = new int[N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			ar[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			boolean swapFlag = false;
			int minIndex = i;
			for (int j = i + 1,min = ar[minIndex]; j < N; j++) {
				if ( ar[j] < min ){
					min = ar[j];
					minIndex = j;
					swapFlag = true;
				}
			}
			if (swapFlag) {
				int temp = ar[i];
				ar[i] = ar[minIndex];
				ar[minIndex] = temp;
				cnt++;
			}
		}
	
	for (int i = 0; i < N; i++) {
		System.out.print(ar[i]);
		if (i + 1 < N) {
			System.out.print(" ");
		} else {
			System.out.println();
		}
	}
	
	System.out.println(cnt);
	}
}
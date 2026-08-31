import java.util.*;
import java.math.*;
import java.awt.geom.*;
import java.io.*;
    
    
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int ans = selectionSort(a,n);
		System.out.print(a[0]);
		for(int i = 1; i < n; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
		System.out.println(ans);
		
	}
	static int selectionSort(int[] A, int N) {
		int ret = 0;
		for(int i = 0; i < N; i++) {
			int minj = i;
			for(int j = i; j < N; j++) {
				if(A[j] < A[minj]) {
					minj = j;
				}
			}
			if(i != minj) {
				ret++;
				int tmp = A[i];
				A[i] = A[minj];
				A[minj] = tmp;
			}
		}
		return ret;
	}
}
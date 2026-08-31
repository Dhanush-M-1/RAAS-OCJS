import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Math.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Class_4 {
	public static boolean f(char a) {
		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'y') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int left = 1;
		int right = 1000000;
		int index_r = n - 1;
		int index_l = 0;
		int sum = 0;
		int delta_r = 0;
		int delta_l = 0;
		int count = 0;
		while (count != n) {
			delta_r = Math.abs(right - a[index_r]);
			delta_l = Math.abs(a[index_l] - left);
			if (delta_l <= delta_r) {
				sum += delta_l;
				left = a[index_l];
				right -= delta_l;
				index_l++;
				count++;
			} else {
				sum += delta_r;
				right = a[index_r];
				left += delta_r;
				index_r--;
				count++;
			}
		}
		System.out.println(sum);
	}
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Bear {

	public static int[] getArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = sr.nextInt();
		}
		return array;
	}

	public static int[][] getMatrix(int sizeI, int sizeJ) {
		int[][] array = new int[sizeI][sizeJ];
		for (int i = 0; i < sizeI; i++) {
			for (int j = 0; j < sizeJ; j++) {
				array[i][j] = sr.nextInt();
			}
		}
		return array;
	}

	static Scanner sr = new Scanner(System.in);

	public static void main(String[] args) {

		int days = sr.nextInt();
		int leasePrice = sr.nextInt();
		int[] dayPrices = new int[days];
		int[] difference = new int[days-1];
		dayPrices = getArray(days);
		for (int i = 0; i < difference.length; i++) {
			difference[i] = dayPrices[i] - dayPrices[i+1];
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < difference.length; i++) {
			if(difference[i] > max) max = difference[i];
		}
		
		int result = max - leasePrice;
		if(result < 0 ) result = 0;
		System.out.println(result);
//		System.out.println(Arrays.toString(dayPrices));
//		System.out.println(Arrays.toString(difference));
	}
}
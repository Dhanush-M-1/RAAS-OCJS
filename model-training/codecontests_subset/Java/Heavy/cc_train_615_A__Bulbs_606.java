import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Lampochki {

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

		int buttonsAmount = sr.nextInt();
		int lightbulbsAmount = sr.nextInt();
		int lamps[] = new int[lightbulbsAmount];
		for (int i = 1; i <= lightbulbsAmount; i++) {
			lamps[i-1] = i;
		}
		boolean isOK = false;
		for (int i = 0; i < buttonsAmount; i++) {
			int buttonValue = sr.nextInt();
			for (int j = 0; j < buttonValue; j++) {
				int value = sr.nextInt();
				for (int j2 = 0; j2 < lamps.length; j2++) {
					if (lamps[j2] == value) {
						lamps[j2] = 0;
						break;
					}
				}
			}
		}
		isOK = true;
		for (int i = 0; i < lamps.length; i++) {
			if (lamps[i] != 0) {
				isOK = false;
				break;
			}
		}
//		System.out.println(Arrays.toString(lamps));
		System.out.println(isOK ? "YES" : "NO");
	}
}
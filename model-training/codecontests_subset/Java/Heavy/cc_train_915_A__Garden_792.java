import java.util.Arrays;
import java.util.Scanner;

public class Sad {

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
	
		int size = sr.nextInt();
		int gardenSize = sr.nextInt();
		int array[] = new int[size];
		array = getArray(size);
		int answer = 1;
		Arrays.sort(array);
		for (int i = size - 1; i >= 0; i--) {
			if(gardenSize % array[i] == 0){
				answer = gardenSize / array[i];
				break;
			}
		}
		System.out.println(answer);
	}
}
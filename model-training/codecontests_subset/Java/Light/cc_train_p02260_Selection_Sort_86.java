import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		byte[] array = new byte[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextByte();
		}
		byte minJ = 0;
		int count = 0;
		for (byte i = 0; i < array.length; i++) {
			minJ = i;
			for (byte j = i; j < array.length; j++) {
				if (array[j] < array[minJ]) {
					minJ = j;
				}
			}
			if (i != minJ) {
				swap(array, minJ, i);
				count++;
			}
		}
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[array.length - 1]);
		System.out.println(count);
	}

	static void swap(byte[] array, int x, int y) {
		byte tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
}

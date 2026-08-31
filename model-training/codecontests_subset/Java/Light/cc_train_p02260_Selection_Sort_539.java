import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Main ss = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		ss.select(array);
	}
	public void select(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int k = 0;
			for (int j = i + 1; j < a.length; j++) {
				//minを探す
				if (a[j] < min) {
					min = a[j];
					k = j;
				}
			}
			if (a[i] > min) {
				int past = a[i];
				a[i] = min;
				a[k] = past;
				count++;
			}
		}
		for (int l = 0; l < a.length; l++) {
			System.out.print(a[l]);
			if (l != a.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println("");
		System.out.println(count);
	}

}

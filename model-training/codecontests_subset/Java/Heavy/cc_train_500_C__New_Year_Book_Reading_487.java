import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

	public static int[] readInts(String cad) {
		String read[] = cad.split(" ");
		int res[] = new int[read.length];
		for (int i = 0; i < read.length; i++) {
			res[i] = Integer.parseInt(read[i]);
		}
		return res;
	}

	public static long[] readLongs(String cad) {
		String read[] = cad.split(" ");
		long res[] = new long[read.length];
		for (int i = 0; i < read.length; i++) {
			res[i] = Long.parseLong(read[i]);
		}
		return res;
	}

	static void printArrayInt(int[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println();
	}

	static void printMatrixInt(int[][] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (j > 0)
					System.out.print(" ");
				System.out.print(array[i][j]);
			}
			System.out.println();
		}

	}

	public static int max(int arr[]) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

	public static int min(int arr[]) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		return min;
	}

	public static int w[], b[];
	public static Node v[];

	public static class Node {
		int book;
		int w;

		public Node(int index, int w) {
			this.book = index;
			this.w = w;
		}

		@Override
		public String toString() {
			return book + " " + w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in;
		File f = new File("entrada");
		if (f.exists()) {
			in = new BufferedReader(new FileReader(f));
		} else
			in = new BufferedReader(new InputStreamReader(System.in));

		int d[] = readInts(in.readLine().trim());
		w = readInts(in.readLine().trim());
		b = readInts(in.readLine().trim());
		v = new Node[w.length];

		int index = 0;
		for (int i = 0; i < b.length; i++) {
			boolean r = false;
			for (int j = 0; j < index; j++) {
				if (v[j].book == b[i]) {
					r = true;
				}
			}
			if (!r) {
				v[index] = new Node(b[i], w[b[i] - 1]);
				index++;
			}
		}

		long res = 0;
		index = 0;
		Node temp = null;

		for (int i = 0; i < b.length; i++) {

			for (int j = 0; j < v.length; j++) {
				if (v[j].book == b[i]) {
					index = j;
					temp = v[j];
					break;
				}
			}
			for (int j = index; j > 0; j--) {
				res += v[j - 1].w;
				v[j] = v[j - 1];
			}
			v[0] = temp;
		}
		System.out.println(res);

	}
}

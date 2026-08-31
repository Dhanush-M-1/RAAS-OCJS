import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int size = in.nextInt(), arr[] = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(in.next());
		}

		int query = in.nextInt();
		for(int i = 0; i < query; i++) {
			int begin = Integer.parseInt(in.next()), end = Integer.parseInt(in.next()), target = Integer.parseInt(in.next());

			for(int j = 0; j < end - begin; j++) {
				int temp = arr[begin + j];
				arr[begin + j] = arr[target + j];
				arr[target + j] = temp;
			}

		}

		for(int i = 0; i < size; i++) {
			out.printf("%d%s", arr[i], (i < size - 1) ? " " : "\n");
		}
		out.flush();
		in.close();
	}

}


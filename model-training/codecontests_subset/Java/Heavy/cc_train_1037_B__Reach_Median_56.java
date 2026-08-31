import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String []args) {
		final Scanner sc = new Scanner(System.in);
		final int arraySize = sc.nextInt();
		final long medianTarget = sc.nextLong();
		long result = 0;
		ArrayList<Long> array = new ArrayList<Long>(arraySize);
		for (int i = 0; i < arraySize; i++) {
			array.add(sc.nextLong());
		}

		Collections.sort(array);
		long startingMedian = array.get(arraySize/2);
		if (startingMedian == medianTarget) {
			System.out.println(0);
		} else if (startingMedian > medianTarget) {
			for (int i = arraySize/2; i >= 0 && array.get(i) > medianTarget; i--) {
				result += array.get(i) - medianTarget;
			}

			System.out.println(result);
		} else {
			for (int i = arraySize/2; i < array.size() && array.get(i) < medianTarget; i++) {
				result += medianTarget - array.get(i);
			}

			System.out.println(result);
		}

		sc.close();
	}
}

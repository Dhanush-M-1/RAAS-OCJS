import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		double[] numbers = new double[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Double.parseDouble(split[i]);
		}
		double binaryMin = -10000;
		double binaryMax = 10000;
		double result = 0;
		double lastResult = 28091994;
		while (Math.abs(lastResult - result) > 1e-7) {
			// System.out.println("binarymin" + binaryMin);
			// System.out.println("binarymax" + binaryMax);
			double pivot = (binaryMax + binaryMin) / 2;
			// System.out.println("PIVOT " + pivot);
			lastResult = result;
			result = f(n, numbers, pivot);
			// System.out.println("result" + result);
			// System.out.println("-----------");
			if (result > 0) {
				binaryMax = pivot;
			} else {
				binaryMin = pivot;
			}
		}
		System.out.println(Math.abs(result));

	}

	private static double f(int n, double[] numbers, double x) {
		double max = 0.0;
		double min = 0.0;
		double imin = 0.0;
		double imax = 0.0;

		for (int i = 0; i < numbers.length; i++) {
			double number = numbers[i] + x;
			double newMax = imax + number;
			if (newMax > 0) {
				imax = newMax;
			} else {
				imax = 0;
			}

			double newMin = imin + number;
			if (newMin < 0) {
				imin = newMin;
			} else {
				imin = 0;
			}
			if (newMax > max) {
				max = newMax;
			}
			if (newMin < min) {
				min = newMin;
			}
		}
		double restaDeAbs = Math.abs(max) - Math.abs(min);
		// System.out.println("restadeabs" + restaDeAbs);
		// System.out.println("absmax" + Math.abs(max));
		// System.out.println("absmin" + Math.abs(min));
		// if (Math.abs(restaDeAbs) < 1e-9) {
		// return 0;
		// }
		return (restaDeAbs > 0) ? Math.abs(max) : -Math.abs(min);
	}

}

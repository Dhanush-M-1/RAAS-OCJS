import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int countRectangle = 0;
			int countRhombus = 0;
			while (sc.hasNextLine()) {
				String[] input = sc.nextLine().split(",");
				int[] x = new int[3];
				for (int i = 0; i < 3; i++)
					x[i] = Integer.parseInt(input[i]);
				if (x[0] * x[0] + x[1] * x[1] == x[2] * x[2])
					countRectangle++;
				else if (x[0] == x[1])
					countRhombus++;
			}
			System.out.println(countRectangle);
			System.out.println(countRhombus);
		} finally {
			sc.close();
		}
	}
}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int counter = 0;
		while (scanner.hasNext()) {

			counter = scanner.nextInt();
			if (counter == 0) {
				break;
			}


			int point = 0;

			boolean left = false;
			boolean right = false;
			boolean status = false;

			for (int i = 0; i < counter; i++) {

				String action = scanner.next();

				switch (action) {
				case "lu":
					left = true;
					break;
				case "ld":
					left = false;
					break;
				case "ru":
					right = true;
					break;
				case "rd":
					right = false;
					break;
				}

				if (left && right && !status) {
					point = point + 1;
					status = true;
				}
				if (!left && !right && status) {
					point = point + 1;
					status = false;
				}
			}

			System.out.println(point);
		}

		scanner.close();
	}
}


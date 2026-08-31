import java.util.Scanner;

//20180508
//08

public class Main {
    public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			int h = scanner.nextInt();
			int w = scanner.nextInt();

			if(h == 0 && w == 0) {
				break;
			}

			for (int y = 1; y <= h; y++) {
				for (int x = 1;x <= w;x++) {
					if((x + y) % 2 == 0) {
						System.out.print("#");
					} else {
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
		}

    	scanner.close();
    }
}

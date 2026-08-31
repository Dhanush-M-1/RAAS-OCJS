import java.util.Scanner;

public class Main{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {

			int height = Integer.parseInt(sc.next());
			int width  = Integer.parseInt(sc.next());

			if(height == 0 && width == 0) {
				break;
			}

			for(int i = 0; i< height;i++) {

				for(int j = 0; j <width;j++) {

					if((j+i) %2 == 0) {
						System.out.print("#");
					}else {
						System.out.print(".");
					}

				}
				System.out.println();
			}

			System.out.println();



		}


		sc.close();
	}

}

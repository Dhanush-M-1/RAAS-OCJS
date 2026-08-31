import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int H,W;
		H = scan.nextInt();
		W = scan.nextInt();

		while(H != 0 && W != 0){
			for(int i = 0; i < H; i++){
				for(int j = 0; j < W; j++){
					if((i+j)%2 == 0)
						System.out.printf("#");
					else
						System.out.printf(".");
				}
				System.out.printf("\n");
			}
			System.out.printf("\n");
			H = scan.nextInt();
			W = scan.nextInt();
		}
	}
}
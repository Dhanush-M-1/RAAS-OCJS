import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		while(true){
			int H = stdIn.nextInt();
			int W = stdIn.nextInt();
			if(H == 0 && W == 0)
				break;
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (((i+j)&1) == 0) {
						System.out.print("#");
					}else{
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
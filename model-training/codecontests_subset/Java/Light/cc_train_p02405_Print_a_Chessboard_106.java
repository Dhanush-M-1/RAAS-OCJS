import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int x,y;
		while(true) {
			int H=scan.nextInt();
			int W=scan.nextInt();
			if(H == 0 && W == 0) break;
			for(y=0;y<H;y++) {
				for(x=0;x<W;x++) {
				if((x+y)%2 == 0) {
					System.out.printf("#");
				}
				else{
						System.out.printf(".");
				}
				}
				System.out.printf("\n");
			}
			System.out.printf("\n");
		}
		scan.close();
}
}

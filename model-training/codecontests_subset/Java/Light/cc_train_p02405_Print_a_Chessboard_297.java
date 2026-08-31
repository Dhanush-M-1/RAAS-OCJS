import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			for(;;) {
				int h = sc.nextInt();
				int w = sc.nextInt();
				if(h==0&&w==0) break;
				for(int i=0; i<h; i++) {
					for(int j=0; j<w; j++) {
						System.out.print((i+j)%2==0?"#":".");
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}
}

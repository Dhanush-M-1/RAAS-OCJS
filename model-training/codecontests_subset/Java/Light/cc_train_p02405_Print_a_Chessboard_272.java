import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int H, W, i, j, flag;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			H = scan.nextInt();
			W = scan.nextInt();
			
			if(H == 0 && W == 0) break;
			
			for(i = 0; i < H; i++) {
				
				//奇数行目の時flag=-1とする
				if(i % 2 == 1) flag = -1;
				else flag = 1;
				
				for(j = 0; j < W; j++) {
					if(flag == 1) System.out.printf("#");
					else System.out.printf(".");
					flag *= -1;
				}
				
				System.out.println();
				
			}
			
			System.out.println();
			
		}
		
	}

}

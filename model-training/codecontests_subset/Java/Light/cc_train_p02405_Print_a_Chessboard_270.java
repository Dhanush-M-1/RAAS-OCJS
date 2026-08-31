import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			
			if(h == 0) break;
			
			int check = 0;
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(check % 2 == 0) {
						System.out.print('#');
					}else {
						System.out.print('.');
					}
					check++;
				}
				if(w % 2 == 0) check++;
				System.out.println();
			}
			System.out.println();
		}
		
	}

}


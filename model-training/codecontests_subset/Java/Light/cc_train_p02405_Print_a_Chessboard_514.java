import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int H;
		int W;
		while(true){
			H = sc.nextInt();
			W = sc.nextInt();
			if ((H == 0) && (W == 0)){break;}
			String[] str = new String[]{"#", "."};
			for (int i = 1; i <= H; i++){
				if (i % 2 == 0){
					for(int j = 1; j <= W; j++){
						System.out.print(str[j % 2]);
					}
				} else {
					for (int j = 1; j <= W; j++){
						System.out.print(str[(j + 1) % 2]);
					}
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}
}
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		//データ入力の準備
		Scanner sc = new Scanner(System.in);
		
		while (true){
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			if (h == 0 && w == 0){
				break;
			}
			
			//結果を出力
			print(h, w);
		}
	}
	
	
	private static void print(int h, int w){
		for (int i = 0; i < h; i++){
			for (int j = 0; j < w; j++){
				if ((i + j) % 2 == 0){
					System.out.print("#");
				}else{
					System.out.print(".");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// 標準入力からデータを読み込む準備
		Scanner sc = new Scanner(System.in);

		// 最初の文字の固まりを整数値と想定して読み込む
		while (true) 	{
			int H = sc.nextInt();
			int W= sc.nextInt();
			if (H == 0 && W == 0) {
				break; 
			}
			// 二重ループ(forの中にfor)を書いて、. と # を交互に表示しよう!
			for(int i=1;i<=H;i++){
				for(int j=1;j<=W;j++){
					if(((j%2==0)&&(i%2!=0))||((j%2!=0)&&(i%2==0)))
						System.out.printf(".");
					else
						System.out.printf("#");
				}
				System.out.printf("\n");
			}
			System.out.printf("\n");
		}
	sc.close();
	}

}

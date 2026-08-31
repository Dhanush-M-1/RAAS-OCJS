/**
 * 
 */
import java.util.*;
/**
 * @author akira
 *
 */
class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		while(true){
			int h, m, s;
			h = scan.nextInt();
			m = scan.nextInt();
			s = scan.nextInt();
			if(h == -1 && m == -1 && s == -1){
				break;
			}
			int trl1 = 2 * 3600 - (h * 3600 + m * 60 + s);
			int trl2 = 3 * trl1;
			int[] t = {3600,60,1};
			for(int i = 0;i < 3;i++){
				if(i != 0){
					System.out.print(":");
				}
				System.out.format("%02d", trl1 / t[i]);
				trl1 -= (trl1 / t[i]) * t[i];
			}
			System.out.println("");

			for(int i = 0;i < 3;i++){
				if(i != 0){
					System.out.print(":");
				}
				System.out.format("%02d", trl2 / t[i]);
				trl2 -= (trl2 / t[i]) * t[i];
			}
			System.out.println("");
		}
	}

}
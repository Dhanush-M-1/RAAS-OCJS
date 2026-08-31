import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);

		int dishNum = scan.nextInt();
		int manzoku = 0;

		int[] a = new int[dishNum];
		int[] b = new int[dishNum];
		int[] c = new int[dishNum];

		for(int i=0;i<dishNum;i++) {
			a[i] = scan.nextInt();
		}
		for(int i=0;i<dishNum;i++) {
			b[i] = scan.nextInt();
		}
		for(int i=0;i<dishNum-1;i++) {
			c[i] = scan.nextInt();
		}

		for(int i=0;i<dishNum;i++) {
			manzoku += b[a[i]-1];
			if(i != 0) {
				if(a[i-1]+1==a[i]) {
					manzoku += c[a[i]-2];
				}
			}
		}
		System.out.println(manzoku);
	}

}

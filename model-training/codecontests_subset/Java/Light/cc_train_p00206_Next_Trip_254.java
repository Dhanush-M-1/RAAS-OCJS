import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int hiyou = sc.nextInt();
			int month = 0;
			int flg = 0;
			if(hiyou == 0 ) break;
			for(int i = 0 ; i < 12 ; i++){
				int m = sc.nextInt();
				int n = sc.nextInt();
				hiyou -= m - n;
				if(hiyou <= 0 && flg == 0) {
					month = i + 1;
					flg = 1;
				}
			}
			if(month == 0){
				System.out.println("NA");
			} else {
				System.out.println(month);
			}
			
		}
		sc.close();
	}

}
import java.util.*;

public class Main {
	public Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		new aoj2424().doIt();
	}
	class aoj2424{
		void doIt() {
			int n = sc.nextInt();
			for(int i = 0;i < n;i++){
				int num = sc.nextInt();
				int cnt = 0;
				while(true){
					if(num / 10 == 0)break;
					else{
						int num2 = num;
						int max = 0;
						int bai = 10;
						while(bai < num2){
							int sum = (num2 / bai) * (num % bai);
							if(sum > max) max = sum;
							bai = bai * 10;
						}
						num = max;
					}
					cnt++;
				}
				System.out.println(cnt);
			}
		}
	}
}
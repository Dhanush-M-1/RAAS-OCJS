import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int flag, num, cnt = 0;
		
		for(int i = 0; i < n; i++) {
			flag = 0;
			
			num = sc.nextInt();
			
			if(num % 2 == 0 && num != 2) {
				flag = 1;
			}
			
			for(int j = 3; j <= Math.sqrt(num) && flag == 0; j+=2) {
				if(num % j == 0) {
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
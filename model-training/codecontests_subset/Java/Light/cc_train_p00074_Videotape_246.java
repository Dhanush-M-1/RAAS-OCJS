import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==-1 && b==-1 && c==-1)break;
			
			int total = (a*60+b)*60+c;
			
			int d = 120*60 - total;
			int e = 120*60*3 - total*3;
			
			int[] ans = new int[3];
			
			ans[2] = d%60;
			d /= 60;
			ans[1] = d%60;
			d /= 60;
			ans[0] = d%60;
			
			System.out.printf("%02d:", ans[0]);
			System.out.printf("%02d:", ans[1]);
			System.out.printf("%02d", ans[2]);
			System.out.println();
			
			ans[2] = e%60;
			e /= 60;
			ans[1] = e%60;
			e /= 60;
			ans[0] = e%60;
			
			System.out.printf("%02d:", ans[0]);
			System.out.printf("%02d:", ans[1]);
			System.out.printf("%02d", ans[2]);
			System.out.println();
			
		}

	}
}
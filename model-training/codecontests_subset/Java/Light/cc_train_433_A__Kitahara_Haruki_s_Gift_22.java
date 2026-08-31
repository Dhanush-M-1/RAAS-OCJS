
import java.util.Scanner;

public class solverA {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		long sum = 0;
		if (n == 1) {
			System.out.println("NO");
			return;
		}
		int cntA = 0;
		int cntB = 0;
		for (int i = 0; i < n; i++){
			int w = sc.nextInt(); 
			sum += w / 100;
			if (w == 200) cntA++;
			else cntB++;
		}
		if (cntA % 2 == 0 && cntB % 2 ==0){
			System.out.println("YES");
		}
		else if (cntA % 2 == 1 && (cntB % 2 == 0 && cntB != 0)){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

	}

}
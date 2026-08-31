import java.util.Scanner;
import java.util.Arrays;

public class Equation_By_Dividing {

	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int [] a = new int [n];
		for (int u = 0; u < n; u++)
			a[u] = in.nextInt();
		in.close();
		
		int MAX = 0;
		for (int v = 0; v < n; v++)
			MAX = Math.max(MAX, a[v]);
		
		int actions = 100000;
		for (int i = 0; i <= MAX; i++){
			int [] cnt = new int [n];
			Arrays.fill(cnt, 100000);
			for (int j = 0; j < n; j++){
				int num = a[j];
				int div = 0;
				while(num >= i){
					if (num == i){
						cnt[j] = div;
						break;
					}
					num /= 2;
					div++;
				}
			}
			Arrays.sort(cnt);
			int ac = 0;
			for (int z = 0; z < k; z++)
				ac += cnt[z];
			actions = Math.min(actions, ac);
		}
		System.out.print(actions);
	}

}
import java.util.Arrays;
import java.util.Scanner;


public class A_210 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int array[] = new int[n+1];
		int increased[] = new int[n+1];
		Arrays.fill(array, 1000000000);
		int ops[][] = new int[m][];
		
		for(int i = 0; i < m; i++){
			int t = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			int dm = in.nextInt();
			ops[i] = new int[4];
			ops[i][0] = t;
			ops[i][1] = l;
			ops[i][2] = r;
			ops[i][3] = dm;
			if(t == 1){
				for(int j = l; j <= r; j++){
					increased[j] += dm;
				}
			} else if(t == 2){
				//System.out.println("new 2 op");
				for(int j = l; j <= r; j++){
					//System.out.println("t=2. array["+i+"] = " + array[j] + " dm = " + dm +" increased[j] = "+ increased[j]);
					array[j] = Math.min(array[j], dm - increased[j]);
					//System.out.println("now:. array["+j+"] = " + array[j]);
					
				}
			}
		}
		int[] checkArr = array.clone();
		boolean ok = true;
		for(int i = 0; i < m; i++){
			int t = ops[i][0];
			int l = ops[i][1];
			int r = ops[i][2];
			int dm = ops[i][3];
			if(t == 1){
				for(int j = l; j <=r; j++){
					checkArr[j] += dm;
				}
			} else if(t == 2){
				int max = Integer.MIN_VALUE;
				for(int j = l; j <=r; j++){
					max = Math.max(max, checkArr[j]);
				}
				if(max != dm){
					ok = false;
					break;
				}
			}
		}
		
		if(ok){
			System.out.println("YES");
			for(int i = 1; i <= n; i++){
				System.out.print(array[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("NO");
		}
		
		
		
		
	}

}

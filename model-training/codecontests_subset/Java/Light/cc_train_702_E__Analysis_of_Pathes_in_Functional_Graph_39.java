
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long k = in.nextLong();
		int[][] next = new int[n][35];
		long[][] sums = new long[n][35];
		int[][] mins = new int[n][35];
		for(int i=0;i<n;i++){
			next[i][0] = in.nextInt();
		}
		for(int i=0;i<n;i++){
			int temp = in.nextInt();
			mins[i][0] = temp;
			sums[i][0] = temp;
		}
		for(int j=1;j<=34;j++){
			for(int i=0;i<n;i++){
				next[i][j] = next[next[i][j-1]][j-1];
				sums[i][j] = sums[i][j-1] + sums[next[i][j-1]][j-1];
				mins[i][j] = Math.min(mins[i][j-1], mins[next[i][j-1]][j-1]);
//				System.out.println(i + " " + j + " " + next[i][j] + " " + sums[i][j] + " " + mins[i][j]);
			}
		}
		for(int i=0;i<n;i++){
			long sum = 0;
			int min = Integer.MAX_VALUE;
			int curr = i;
			for(int j=34;j>=0;j--){
//				System.out.println(j + " " + ((long)1 << j) + " " + (k & ((long)1 << j)));
				if((k & ((long)1 << j)) != 0){
					sum += sums[curr][j];
					min = Math.min(min, mins[curr][j]);
					curr = next[curr][j];
//					System.out.println(curr);
				}
			}
			System.out.println(sum + " " + min);
		}
	}

}

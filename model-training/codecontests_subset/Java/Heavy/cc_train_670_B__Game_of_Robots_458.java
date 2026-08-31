
import java.util.Scanner;

public class GameOfRobots {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[]id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = sc.nextInt();
		}
		int[] sum = new int[(int)1e6+1];
		sum[1] = 1;
		int start = 0;
		int i= 1;
		for ( i = 1; i < k; i++) {
			sum[i] = sum[i-1] + i; 
			if(sum[i] >= k){
				start = sum[i];
				break;
			}
		}
		if(sum[i] == k)
			System.out.println(id[i-1]);
		else
		{
			start = sum[i-1];
			i = 0;
			for (; start < k; start++) {
				i++;
			}
			System.out.println(id[i-1]);
		}
		
	}
}

import java.util.Scanner;

public class ProblemBGameOfRobots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		int N, k;
		N = inp.nextInt();
		k = inp.nextInt();
		
		int[] arr = new int[N];
		int i = 0;
		while (i < N) {
			arr[i] = inp.nextInt();
			i++;
		}
		int prev_sum = 0;
		int index = -1;
		for (int j = 0; j < N; j++) {
			if (prev_sum + (j+1) < k) {
				prev_sum += (j+1);
			} else {
				index = k - prev_sum - 1;
				break;
			}
		}
		System.out.println(arr[index]);
		inp.close();
	}
}
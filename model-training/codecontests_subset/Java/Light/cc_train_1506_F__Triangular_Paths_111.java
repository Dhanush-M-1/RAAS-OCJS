import java.util.Arrays;
import java.util.Scanner;

public class solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int k = 0; k < t; k++) {
			int n = s.nextInt();
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) 
				arr[i][0] = s.nextInt();
			for (int i = 0; i < n; i++)
				arr[i][1] = s.nextInt();
			Arrays.sort(arr, (a, b)->(a[0]-b[0]));
			long res = calculate(1, 1, arr[0][0], arr[0][1]);
			for(int i=1; i<n; i++)
				res += calculate(arr[i-1][0], arr[i-1][1], arr[i][0], arr[i][1]);
			System.out.println(res);
		}
	}
	
	public static long calculate(int sr, int sc, int er, int ec)  {
		if(er - sr == ec - sc)
			return (sr+sc)%2 == 0 ? er - sr : 0;
		int temp = (er - sr) - (ec - sc);
		return (sr+sc)%2 == 0 ? temp/2 : (temp+1)/2;
	}

}
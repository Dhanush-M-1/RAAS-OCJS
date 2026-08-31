import java.util.*;

public class Main{
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scan.nextInt();
		}

		int count = 0;
		for(int i = 0; i < n; i++){
			int minj = i;
			for(int j = i; j < n; j++){
				if(arr[j] < arr[minj]){
					minj = j;
				}
			}
			if(i != minj){
				int small = arr[minj];
				arr[minj] = arr[i];
				arr[i] = small;
				count++;
			}
		}

		for(int i = 0; i < n; i++){
			System.out.printf(i != n-1? "%d ": "%d\n", arr[i]);
		}
		System.out.printf("%d\n", count);
	}
}
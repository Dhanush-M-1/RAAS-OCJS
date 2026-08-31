
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class badDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = s.nextInt();
		int k = s.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int ans = Integer.MAX_VALUE;
		ArrayList<Integer>[] listarr = new ArrayList[200006];
		for(int i = 0; i < 200006; i++) {
			listarr[i]= new ArrayList<>();
		}
		for(int i = 0; i < n; i++) {
			int x = arr[i];
			int div = 0;
			while(x>0) {
				listarr[x].add(div);
				div++;
				x>>=1;
			}
		}
		for(int i = 0; i < 200006; i++) {
			if(listarr[i].size()<k) {
				continue;
			}
			ArrayList<Integer> curr = listarr[i];
			Collections.sort(curr);
			int temp = 0;
			for(int j = 0; j < k; j++) {
				temp+=curr.get(j);
			}
			ans = Math.min(ans, temp);
		}
		System.out.println(ans);
	}
}

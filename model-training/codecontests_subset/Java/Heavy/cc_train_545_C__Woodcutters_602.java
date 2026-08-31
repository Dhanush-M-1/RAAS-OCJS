import java.util.*;

public class CodeForces545C{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] right = new int[n];
		int[] left = new int[n];
		int[] a = new int[n];
		for(int i = 0;i<n;i++){
			int x = input.nextInt();
			int h = input.nextInt();
			a[i] = x;
			right[i] = x+h;
			left[i] = x-h;
		}
		int count = 1;
		int c = left[0];
		for(int i = 1;i<n-1;i++){
			boolean bool = true;
			if(left[i] > a[i-1] && c < left[i]){
				c = left[i];
				count++;
				bool = false;
			}
			if(bool && right[i] < a[i+1]){
				count++;
				c = right[i];
			}
		}
		if(a.length == 1){
			System.out.println(count);
		}
		else{
			System.out.println(count+1);
		}
	}
}
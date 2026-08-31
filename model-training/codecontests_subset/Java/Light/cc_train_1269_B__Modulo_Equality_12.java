import java.util.*;
public class modulo_equality {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		for(int i =0;i<n;i++) {
			arr1[i] = s.nextInt();
		}
		for(int i =0;i<n;i++) {
			arr2[i] = s.nextInt();
		}
		//Arrays.sort(arr1);
		Arrays.sort(arr2);
		int p = m;
		for(int i=0;i<n;i++) {
			int x = (arr2[i]-arr1[0]+m)%m;
			int[] temp = new int[n];
			boolean ans = true;
			for(int j =0;j<n;j++) {
				temp[j] = (arr1[j]+x)%m;
			}
			Arrays.sort(temp);
			for(int j =0;j<n;j++) {
				if(temp[j]!=arr2[j]) {
					ans = false;
				}
			}
			if(ans) {
				p = Math.min(x, p);
			}
		}
		System.out.println(p);
	}

}
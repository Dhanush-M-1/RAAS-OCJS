import java.util.*;

public class CaninePoetry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t-- > 0) {
			char[] arr = sc.nextLine().toCharArray();
			boolean[]dp=new boolean[arr.length];
			int count = 0;
			for (int i = 1; i < arr.length; i++) {
				if(arr[i]==arr[i-1] && !dp[i-1]) {
					count++;
					dp[i]=true;
				}
				if(i>1 && arr[i]==arr[i-2] && !dp[i-2]) {
					count++;
					dp[i]=true;
				}
				
			}
			System.out.println(count);
		}

	}

}

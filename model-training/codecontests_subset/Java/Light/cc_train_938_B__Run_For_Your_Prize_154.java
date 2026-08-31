import java.util.Scanner;

public class _0969RunForYourPrize {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int first=0;
		int second=1000000;
		int mid=1000000/2;
		for(int i=0;i<n;i++) {
			int temp=sc.nextInt();
			if(temp<=mid) {
				first=Math.max(first, temp);
			}
			else {
				second=Math.min(second, temp);
			}
		}
		int ans=Math.max((first-1),(1000000-second));
		System.out.println(ans);
	}

}

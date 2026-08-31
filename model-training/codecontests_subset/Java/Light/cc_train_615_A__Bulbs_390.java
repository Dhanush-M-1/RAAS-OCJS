import java.util.Scanner;


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m =sc.nextInt();
		int []arr= new int[m+1];
		for (int i = 0; i < n; i++) {
			int num=sc.nextInt();
			for (int j = 0; j < num; j++) {
				int l=sc.nextInt();
				arr[l]=1;
			}
		}
		boolean can = true;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]!=1){
				can = false;
				break;
			}
		}
		if(can)System.out.println("YES");
		else System.out.println("NO");
	}
}

import java.util.Scanner;

public class code16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++) arr[i] = scn.nextInt();
			int flag = 0;
			boolean countu = true;
			for(int i=1; i<n; i++) {
				int a = n - i - 1;
				int b = i;
				if(arr[i] == a && arr[i-1] == arr[i] && b==a+1) {
					flag = 1;
					break;
				}
				if(countu) {
					if(arr[i]<b)
						countu = false;
				} 
				if(!countu){
					if(arr[i]<a) {
						flag = 1;
						break;
					}
				}
			}
			if(flag == 1)
				System.out.println("No");
			else {
				System.out.println("Yes");
			}
		}
	}

}

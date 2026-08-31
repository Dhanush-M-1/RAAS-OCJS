import java.util.Scanner;
public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		int[] all = new int[n];
		for(int i=0;i<n-1;i++) {
			int a = read.nextInt()-1;
			int b = read.nextInt()-1;
			all[a]++;
			all[b]++;
			
		}
		int flag = 1;
		for(int i=0;i<n;i++) {
			if(all[i]==2) {
				flag = 0;
				break;
			}
		}
		if(flag==1) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}	

}

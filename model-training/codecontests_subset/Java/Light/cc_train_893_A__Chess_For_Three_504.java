import java.util.Scanner;

public class ChessForThree {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int winner[]=new int[n];
		for (int i=0;i<n;i++) {
			winner[i]=sc.nextInt();
		}
		
		boolean active[]= {true,true,false};
		
		if (winner[0]==1 || winner[0]==2) {
			if (winner[0]==1) {
				active[1]=false;
			}
			else if (winner[0]==2){
				active[0]=false;
			}
			active[2]=true;
		}
		else {
			System.out.println("NO");
			return;
		}
		
		int currentWinnerIndex=0;
		boolean temp;
		for (int i=1;i<n;i++) {
			currentWinnerIndex=winner[i]-1;
			if (active[winner[i]-1]) {
				for (int j=0;j<=2;j++) {
					if (j==currentWinnerIndex) {
						continue;
					}
					temp=active[j];
					active[j]=!temp;
				}
			}
			else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}

import java.util.Scanner;

public class _0535ChessForThree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int player1=1;
		int player2=2;
		int spectator=3;
		
		for(int i=0;i<n;i++) {
			int temp=sc.nextInt();
			if(temp!=player1 && temp!=player2) {
				System.out.println("NO");
				return;
			}
			else {
				if(player1==temp) {
					int lol=player2;
					player2=spectator;
					spectator=lol;
				}
				else {
					int lol=player1;
					player1=spectator;
					spectator=lol;
				}
				
			}
		}
		System.out.println("YES");
		

}
}

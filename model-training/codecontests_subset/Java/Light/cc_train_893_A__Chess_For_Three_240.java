import java.util.Scanner;

public class ChessforGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int player= 3;
		boolean condition  = false;
		for(int i=1;i<=n;i++){
			int z = input.nextInt();
			if(z==player){
				condition= true;
			}
			if(z+player==3)player=3;
			else if(z+player==4)player=2;
			else if(z+player==5)player=1;
		}
		if(condition)System.out.println("NO");
		else
			System.out.println("YES");
	}

}

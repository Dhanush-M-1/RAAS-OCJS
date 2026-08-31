import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int n;
		Boolean[][] card = new Boolean[4][13];
		for(int i=0;i<4;i++)
			for(int j=0;j<13;j++)
				card[i][j]=false;
		String suit;
		String[] Suits = {"S","H","C","D"};
		int value;
		
		
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		
		for(int i=0;i<n;i++){
			suit = scan.next();
			value = scan.nextInt();
			switch(suit){
				case "S":
					card[0][value-1]=true;
					break;
				case "H":
					card[1][value-1]=true;
					break;
				case "C":
					card[2][value-1]=true;
					break;
				case "D":
					card[3][value-1]=true;
					break;
			}
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				if(card[i][j]==false){
					System.out.println(Suits[i] + " " + (j+1));
				}
			}
		}
		
		
	}

}

import java.util.Scanner;
public class ProblemB {
	static int player1 = 1;
	static int player2 = 2;
	static int spactator = 3;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {	
		int a = input.nextInt();
		String n = "";
		ProblemB f = new ProblemB();
		for(int i=0;i<a;i++) {
			n = f.game(player1,player2,spactator);
			if(n.equals("NO"))
				break;
		}
		System.out.println(n);
	}
	String game(int player1,int player2,int spactator) {
		int d = input.nextInt();
		if(d==player1) {
			d=spactator;
			this.spactator=player2;
			this.player2=d;
			return "YES";
		}else if(d==player2) {
			d = player1;
			this.player1 = spactator;
			this.spactator = d;
			return "YES";
		}else {
			return "NO";
		}
	}

}

 		  	  	   										   				 	
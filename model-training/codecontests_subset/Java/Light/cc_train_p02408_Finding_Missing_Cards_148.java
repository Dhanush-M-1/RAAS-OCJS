import java.util.Scanner;

public class Main{
	public static void main(String args[]){

		Scanner sc = new Scanner (System.in);

		boolean inhand[][]= new boolean[4][13];
		for (int i=0; i<4;++i){
			for (int j=0;j<13;++j){
				inhand[i][j] = false;
			}
		}
		int n= sc.nextInt();
		String suit;
		int s=0;
		int rank;

		String suitnum[]={"S","H","C","D"};

		for(int i=0; i<n;++i){
			suit = sc.next();
			if (suit.equals("S")) s = 0;
			if (suit.equals( "H")) s = 1;
			if (suit.equals("C")) s =2;
			if (suit.equals( "D")) s =3;
			rank = sc.nextInt();
			inhand[s][rank-1] = true;
		}
		for (int i=0;i<4;++i){
			for (int j=0;j<13;++j){
				if (inhand[i][j] == false){
					System.out.println(suitnum[i]+" "+(j+1));
				}
			}
		}
	}
}

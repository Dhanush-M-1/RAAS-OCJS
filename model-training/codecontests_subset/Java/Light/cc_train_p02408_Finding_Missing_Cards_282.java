
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		
		int n=cin.nextInt();
		boolean cards[][]=new boolean[4][13];
		char simbols[]= {'S','H','C','D'};
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++)cards[i][j]=false;
		}
		
		for(int i=0;i<n;i++) {
			String ssimbol=cin.next();int num=cin.nextInt();
			char simbol=ssimbol.charAt(0);
			if(simbol=='S')cards[0][num-1]=true;
			if(simbol=='H')cards[1][num-1]=true;
			if(simbol=='C')cards[2][num-1]=true;
			if(simbol=='D')cards[3][num-1]=true;
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				if(!cards[i][j])System.out.println(simbols[i]+" "+(j+1));
			}
		}
	}
}

import java.util.Scanner;

public class Main {
public static void main(String [] args){
		
		Scanner scan = new Scanner(System.in);
		
		int cards[][];
		cards = new int[4][13];
		int i, j, num;
		
		for(i=0; i<4; i++){
			num = 1;
			for(j=0; j<13; j++){
				cards[i][j] = num;
				num++;
			}
		}
		
		int a = scan.nextInt();
		for(i=0; i<a; i++){
			char op = scan.next().charAt(0);
			int c = scan.nextInt();
			
			if(op == 'S'){
				cards[0][c-1] = 0; 
			}
			if(op == 'H'){
				cards[1][c-1] = 0; 
			}
			if(op == 'C'){
				cards[2][c-1] = 0; 
			}
			if(op == 'D'){
				cards[3][c-1] = 0; 
			}
		}
		
		for(i=0; i<4; i++){
			for(j=0; j<13; j++){
				if(cards[i][j] != 0){
					if(i==0){
						System.out.println("S "+cards[i][j]);
					}
					if(i==1){
						System.out.println("H "+cards[i][j]);
					}
					if(i==2){
						System.out.println("C "+cards[i][j]);
					}
					if(i==3){
						System.out.println("D "+cards[i][j]);
					}
					
				}
			}
		}
		
	}
}
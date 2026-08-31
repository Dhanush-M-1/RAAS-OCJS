import java.util.Scanner;

public class Main{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		boolean [][] cards = new boolean[4][13];
		String mark = new String();
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++){
			mark = sc.next();
			if(mark.equals("S")){
				cards[0][sc.nextInt()-1] = true; 
			} else if(mark.equals("H")){
				cards[1][sc.nextInt()-1] = true;
			} else if(mark.equals("C")){
				cards[2][sc.nextInt()-1] = true;
			} else if(mark.equals("D")) {
				cards[3][sc.nextInt()-1] = true;
			}
		}
		
		for(int i=0; i<cards.length; i++){
			for(int j=0; j<cards[0].length; j++){
				if(!cards[i][j]){
					if(i==0){
						System.out.println("S "+(j+1));
					}
					else if(i==1){
						System.out.println("H "+(j+1));
					}
					else if(i==2){
						System.out.println("C "+(j+1));
					}
					else if(i==3){
						System.out.println("D "+(j+1));
					}
				}
			}
		}
	}
}
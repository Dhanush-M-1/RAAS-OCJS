import java.util.Scanner;

class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cards[][] = new int[4][13];
		
		for(int i=0;i<n;i++){
			String suit = sc.next();
			int rank = sc.nextInt() - 1;
			
			switch(suit){
			case "S":
				cards[0][rank] = 1;
				break;
			case "H":
				cards[1][rank] = 1;
				break;
			case "C":
				cards[2][rank] = 1;
				break;
			case "D":
				cards[3][rank] = 1;
				break;
			}
		}
		
		for(int j=0;j<4;j++){
			for(int k=0;k<13;k++){
				if(cards[j][k] != 1){
					switch(j){
					    case 0:
					        System.out.println("S "+(k+1));
					        break;
					    case 1:
					        System.out.println("H "+(k+1));
					        break;
					    case 2:
					        System.out.println("C "+(k+1));
					        break;
					    case 3:
					        System.out.println("D "+(k+1));
					}
				}
			}
		}
	}
}


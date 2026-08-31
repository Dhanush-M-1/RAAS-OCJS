import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int x = stdIn.nextInt();
		boolean y[][] = new boolean[4][13];
		for(int i=0; i < x; i++){
			String kind = stdIn.next();
			int number = stdIn.nextInt();
			if(kind.equals("S")) {
				y[0][number-1]= true;
			} else if(kind.equals("H")){
				y[1][number-1]= true;
			} else if(kind.equals("C")){
				y[2][number-1]= true;
			} else if(kind.equals("D")){
				y[3][number-1]= true;
			}
		}
		stdIn.close();
		for(int i=0; i < 4; i++){
			for(int j=0; j < 13; j++){
				if (!y[i][j]) {
					if( i== 0) {
						System.out.println("S " + (j+1));
					} else if(i == 1){
						System.out.println("H " + (j+1));
					} else if(i == 2){
						System.out.println("C " + (j+1));
					} else if(i == 3){
						System.out.println("D " + (j+1));
					}
				}
			}
		}

	}
}


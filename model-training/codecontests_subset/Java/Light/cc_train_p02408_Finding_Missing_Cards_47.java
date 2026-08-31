import java.util.Scanner;
import java.util.Arrays;

class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean[][] numbers = new boolean[4][13];
		
		for(int i = 0; i < n; i++){
			String mark = scanner.next();
			int card = scanner.nextInt();
			if(mark.equals("S")){
				numbers[0][card-1] = true;
			}else if(mark.equals("H")){
				numbers[1][card-1] = true;
			}else if(mark.equals("C")){
				numbers[2][card-1] = true;
			}else if(mark.equals("D")){
				numbers[3][card-1] = true;
			}
		}

		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				if(numbers[i][j] == false){
					if(i==0){
						System.out.println("S " + (j + 1));
					}else if(i==1){
						System.out.println("H " + (j + 1));
					}else if(i==2){
						System.out.println("C " + (j + 1));
					}else if(i==3){
						System.out.println("D " + (j + 1));
					}
				}
			}
		}
	}

}
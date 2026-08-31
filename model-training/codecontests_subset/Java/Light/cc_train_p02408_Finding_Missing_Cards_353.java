import java.util.Scanner;

class Main{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int sheet = scan.nextInt();
		int c = 0;

		int[][] card = new int[4][13];

		for(int i=1; i<=sheet; i++){
			String mark = scan.next();
			int nums = scan.nextInt();

			if(mark.equals("S")){
				card[0][nums-1] = i;
			}else if(mark.equals("H")){
				card[1][nums-1] = i;
			}else if(mark.equals("C")){
				card[2][nums-1] = i;
			}else if(mark.equals("D")){
				card[3][nums-1] = i;
			}
		}
		scan.close();
		for(int i=0; i<4; i++){
			for(int s=0; s<13; s++){
				c = s+1;
				if(card[i][s] == 0){
					if(i == 0){
						System.out.println("S " + c);
					}else if(i == 1){
						System.out.println("H " + c);
					}else if(i == 2){
						System.out.println("C " + c);
					}else if(i == 3){
						System.out.println("D " + c);
					}
				}
			}
		}
	}
}
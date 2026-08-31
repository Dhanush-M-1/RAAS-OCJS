import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int intH;
		int intW;
		while(true){
			intH = scan.nextInt();
			intW = scan.nextInt();
			if(intH == 0 && intW ==0){
				break;
			}
			for(int i = 0; i < intH; i++){
				for(int j = 0; j < intW; j++){
					if((i + j) % 2 == 0){
						System.out.print("#");
					}else{
						System.out.print(".");
					}

				}
				System.out.println();
			}
			System.out.println();
		}

		scan.close();
	}
}
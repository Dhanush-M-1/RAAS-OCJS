public class Main {
	public static void main(String[] args){
		java.util.Scanner scan = new java.util.Scanner(System.in);
		while(true){
			int H = scan.nextInt();
			int W = scan.nextInt();
			if(H == 0 && W == 0)
				break;
			for(int i = 1;i <= H; i++){
				for(int j = 1; j <= W; j++){
					if(((i % 2 == 0) && (i != 0) && (j % 2 == 0) && (j != 0)) || (i % 2 != 0) && (j % 2 != 0)){
						System.out.print("#");
					}else{
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
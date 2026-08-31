import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			if(x == 0 && y == 0)break;
			for ( int i = 0; i < y ; i++ ){
				for ( int j = 0; j < x ; j++ ){
					if((j%2 ==0 && i%2 == 1) || (j%2 ==1 && i%2 == 0) ){
						System.out.print(".");		       
					}else {
						System.out.print("#");
					}	
				}	 
				System.out.println("");	
			}
			System.out.println("");	
		}
	}
	
}


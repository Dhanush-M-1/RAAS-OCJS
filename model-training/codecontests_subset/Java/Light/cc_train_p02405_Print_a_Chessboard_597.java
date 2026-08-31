import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int height;
		int width;
		
		while(true){
			height = scan.nextInt();
			width = scan.nextInt();
			
			if(height == 0 && height == 0 ){
				break;
			}
			
			for (int i = 0; i <= height-1; i++){
				for (int j = 0; j <= width-1; j++){
					if((i+j)%2 == 0){
						System.out.print("#");
					}else{
						System.out.print(".");
					}
				}
				System.out.println("");
			}
			System.out.println("");
		}		
	}
}

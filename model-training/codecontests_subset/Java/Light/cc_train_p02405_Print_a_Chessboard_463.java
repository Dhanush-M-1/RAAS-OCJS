import java.util.Scanner;

public class Main {
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		
		int i,j;
		
		while(true){
			
			int h = scan.nextInt();
			int w = scan.nextInt();
			
			if(h == 0 && w == 0){
				break;
			}
			
			for(i=1; i<=h; i++){
				for(j=1; j<=w; j++){
					if((i+j)%2==0){
						System.out.print('#');
					}else{
						System.out.print('.');
					}
					
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
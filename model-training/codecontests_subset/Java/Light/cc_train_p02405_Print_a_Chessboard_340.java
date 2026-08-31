import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
 
 		while(true){
 			int w = sc.nextInt();
 			int h = sc.nextInt(); 			

 			if(h == 0 && w == 0){break;}

 			for(int i = 1; i <= w; i++){
 				for(int j = 1; j <= h; j++){
 					if((i + j) % 2 == 1){
 						System.out.print(".");
 					}else{
 						System.out.print("#");
 					}
 				}
 	 			System.out.println("");
 			}
 			System.out.println("");
 		}
	}
}
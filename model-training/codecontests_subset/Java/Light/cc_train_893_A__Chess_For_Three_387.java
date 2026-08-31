import java.util.*;

public class A_Chess_For_3 {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int ctst1 = 1;
		int ctst2 = 2;
		int spct = 3;
		int winner;
		int space;
		
		for(int i = 0; i < num; i++){
			winner = in.nextInt();
			
			if(winner == spct){ 
				System.out.print("NO");
				return;
			}
			if(winner == ctst1){
				space  = ctst2;
				ctst2 = spct;
				spct = space;
				continue;
				
			} else if(winner == ctst2){
				space = ctst1;
				ctst1 = spct;
				spct = space;
				continue;
			}
			
			
		
		}
		System.out.print("YES");
		
	}

}

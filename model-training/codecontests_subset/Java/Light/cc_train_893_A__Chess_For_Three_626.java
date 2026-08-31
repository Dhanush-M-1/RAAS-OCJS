import java.util.*;
public class chess {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int player1=1;
		int player2=2;
		int observer=3; 
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();		
		for(int i=0;i<n; i++) {
		   int a = sc.nextInt();
		   if (a == observer) {
			   System.out.println("NO");
			   return;
		   }
           if (a == player1) {
        	   int tmp = player2;
        	   player2=observer;
        	   observer=tmp;
           } else {
        	   int tmp = player1;
        	   player1=observer;
        	   observer=tmp;
           }
		}           
		System.out.println("YES");
		return;
	}
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class CodeForces {

		public static void main(String[] args){
			// 1=alex     2=bob     3=carl
			//alex-bob starts
			
			Scanner s = new Scanner(System.in);
			int n= s.nextInt();
			
			int[] players = new int[3];
			players[0]=1;
			players[1]=1;
			players[2]=0;
			
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
				if(players[arr[i]-1]==0){
					System.out.println("NO");
					System.exit(0);
				}
				else{
					if(arr[i]-1==0){//alex
						players[1]= 1-players[1];
						players[2]=1-players[2];
					}
					else if(arr[i]-1==1){
						players[0]= 1-players[0];
						players[2]=1-players[2];
					}
					else if(arr[i]-1==2){
						players[1]= 1-players[1];
						players[0]=1-players[0];
					}
				}
			}
			System.out.println("YES");		
	    }
}
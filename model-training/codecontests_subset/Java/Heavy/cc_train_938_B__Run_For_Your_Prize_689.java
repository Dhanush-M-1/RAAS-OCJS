import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class CodeForces {
	
		public static void main(String[] args){
			
			Scanner s = new Scanner(System.in);
			int n=s.nextInt();
			int[] arr= new int[n+2];
			arr[0] = 1;
			arr[n+1]= (int)Math.pow(10, 6);
			for (int i = 0; i < n; i++) 
				arr[i+1]=s.nextInt();
					
			int[] prices = new int[n+1];
			
			for(int i=0;i<prices.length;i++)
				prices[i] = Integer.max( arr[i]-1 ,(int) Math.pow(10, 6)-arr[i+1]);
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < prices.length; i++) {
				if(prices[i]<min)
					min=prices[i];
			}
			System.out.println(min);
		}
}
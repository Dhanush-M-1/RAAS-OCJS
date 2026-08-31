//package kitsune;
import java.util.*;
public class letswatchfootbal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		int sum = 1;
		int  i =1;
		while(sum <= (a*c)){
			sum = b*i;
			i++;
			//System.out.println(sum);
			if(sum >= a*c){
				i--;
				break;
			}
				
		}
		System.out.println(i-c);
	}

}

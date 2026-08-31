
import java.util.Scanner;

public class mafia {

	public static int n;
	public static int[]a;
	
	public static boolean check(long mid){
		long temp =0 ;
		for(int i=0 ; i<n ; i++){
			temp += mid - a[i];
		}
		return(temp >= mid);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		a = new int[n];
		long hi = 0;
		long low =0;
		for(int i=0 ; i<n ; i++){
			a[i] = input.nextInt();	
			hi += a[i];
			low = Math.max(low, a[i]);
		}
		
		while(low < hi){
			long mid = low + (hi - low)/2;
			 if(check(mid)){
				 hi = mid;
			 }else{
				 low = mid+1;
			 }
		}
		System.out.println(low);
		input.close();
	}

}

import java.util.Scanner;


public class watchFootball {

	int needed ; 
	int b ;
	int c ;
	int d ;
	public  watchFootball (){
		Scanner stream = new Scanner (System.in);
		int a = stream .nextInt ();
		b = stream.nextInt() ;
		c = stream.nextInt() ;
		needed = a*c ;
		d = b*c ;
		System.out.println(search (a));
		stream.close() ;
	}
	public int search (int a){
		int high = needed ;
		int low = 0 ;
		int mid ;
		for (int i =0 ; i < 1000 ; i++){
			mid = (low+high)/2 ;
			if (check (mid)){
				high = mid ;
			}else {
				low = mid+1 ;
			}
		}
		return high ;
	}
	public boolean check (int mid){
		if ((mid*b + d)>= needed){
			return true ;
		}
		return false ;
	}
	public static void main (String [] args){
		new watchFootball() ;
	}
}

import java.util.Scanner;
public class CowsGame {
	int n ;
	public CowsGame (){
		Scanner stream  = new Scanner (System.in);
		int n = stream.nextInt() ;
		this.n = n ;
		String input = stream.next() ;
		System.out.println(cows (input));
	}
	public int cows (String st){
		int count = 0 ;
		if ((!st.contains("I"))&&(st.contains("A"))){
			for (int i =0 ; i < n; i++){
				if (st.charAt(i) == 'A'){
					count ++ ;
				}
			}
		}else if (st.contains("I")){
			int icount = 0;
			for (int i =0 ; i< n ; i++){
				if (st.charAt(i) == 'I'){
					icount ++ ;
				}
				if (icount > 1){
					count = 0 ;
					break ;
				}else {
					count = 1 ;
				}
			}
		}
		return count ;
	}
	public static void main (String [] args){
		new CowsGame() ;
	}
}
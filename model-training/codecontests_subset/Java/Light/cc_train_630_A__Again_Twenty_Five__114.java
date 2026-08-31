import java.util.*;
public class stepen{
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long pow = (long)Math.pow(5,n);
		String s = pow+"";
		
		if(n>100000){
			System.out.println("25");
		}else{
		System.out.println(s.substring(s.length()-2,s.length()));	
	}
	}
}
import java.util.Arrays;
import java.util.Scanner ; 
public class A219_kString {

	public static void main(String[] args) {
		Scanner ss =new Scanner (System.in) ; 
		int n  = ss.nextInt() ; 
		String s = ss.next();
		String w = "" ; 
		String b ="" ; 
		int c = 1 ; 
		char [] a = new char [s.length()] ;

		for (int i = 0 ; i < s.length() ; i ++ ){
			a[i] = s.charAt(i) ; 
		}
		if (s.length()%n != 0 ){
			System.out.println(-1);
			}
		else {
			boolean kk = true ; 
			Arrays.sort(a);
			for (int i =  0 ; i < s.length() - 1  ; i ++ )  {
				if (a[i] == a[i+1])
					c++ ; 
				else { 
					if (c%n == 0 ){
						for (int j = 0 ; j < c/n ; j++ )
							w+=a[i] ; 
						} 
					else {
						System.out.println(-1);
						kk = false ; 
						break ; 
						}
				c = 1 ; 
			}
		}
			if (c%n == 0 && kk ){
			
				for (int j = 0 ; j < c/n ; j++ )
						w+=a[a.length - 1 ] ; 
				for (int i = 0 ;i < n ; i ++ ) 
					b+=w ; 
					System.out.println(b);
				} 
			

		
			
				
		} 
	}

}

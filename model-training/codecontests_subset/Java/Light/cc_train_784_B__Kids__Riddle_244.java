import java.util.*;
public class main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =  new Scanner(System.in) ;
		int n = in.nextInt() ; 
		String hex  =	Integer.toHexString(n) ; 
		hex =  hex.toUpperCase() ; 
		char  c[] = hex.toCharArray();
		int cnt   =  0 ; 
		
		for(int i  = 0 ; i<c.length  ; i++){
				 if(c[i] == '4' || c[i] ==  '6' || c[i] == '9' || c[i] == '0' || c[i] == 'A' || c[i] == 'D')
					 cnt ++ ; 
				 else if(c[i] == '8' || c[i]  == 'B')
					 cnt +=2 ;
				 
		}
		System.out.println(cnt);
		
	}	
	
}

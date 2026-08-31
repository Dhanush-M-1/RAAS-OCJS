import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner stdin = new Scanner( System.in);
		String S= stdin.next();
		String ans="0";
            
		for(int i=0;i<7;i++) {
			ans=S.substring(0,i)+S.substring(S.length()-7+i);
			if(ans.equals("keyence")) break; 
		}

		if(ans.equals("keyence")) {
			System.out.print("YES");
		}else	System.out.print("NO");


         
           
       
	}
}

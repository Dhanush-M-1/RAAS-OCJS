
import java.util.*;
public class Try1{
	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
			int t = myobj.nextInt();
			
			while(t--!=0) {
				int a = myobj.nextInt();
				int b = myobj.nextInt();
				int n = myobj.nextInt();
				
				if(n%3==0) {
					System.out.println(a);
				}
				else if(n%3==1) {
					System.out.println(b);
				}
				else {
					System.out.println(a^b);
				}
				
			}
	}
	
	
}
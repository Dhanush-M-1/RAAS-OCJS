import java.util.*;
import static java.lang.Math.*;
public class Test{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while (q-->0){
			long l = in.nextLong();
			long r = in.nextLong();
			long d = in.nextLong();
			long ans=0;
			if (l<=d && d<=r){
				
				ans = ((r/d)+1)*d;
			}else{
				ans = d;	
			}
			System.out.println(ans);
			
		}	
	}	
}

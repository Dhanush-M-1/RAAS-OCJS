import java.util.*;

public final class DistApple {
	
	public static void main (String args[]) {
		
		int n,c100=0,c200=0;
		Scanner inp = new Scanner(System.in);
		n = inp.nextInt();
		
		for(int i=0;i<n;i++)
			if(inp.nextInt()== 100)
				c100++;
			else
				c200++;
		
		if((c100!=0)&&(c100%2==0))
			System.out.println("YES");
		else if((c100==0)&&(c200%2==0))
			System.out.println("YES");
		else
			System.out.println("NO");
			
	}
}

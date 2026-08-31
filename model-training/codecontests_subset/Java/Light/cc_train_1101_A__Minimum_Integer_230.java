import java.util.*;
public class MinimumInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		
		while(q-->0)
		{
			int l = sc.nextInt();
			int r = sc.nextInt();
			int d = sc.nextInt();
			if(d<l || d>r)
			{
				System.out.println(d);
			}
			else
			{
				System.out.println(((r/d)+1)*d);
			}
			
		}
	}

}

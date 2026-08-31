import java.util.*;
public class operations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T=in.nextInt(),c=0;
		while(T-->0)
		{
			long n=in.nextLong();
			int two=0,three=0;
			while(n%2==0)
			{
				two++;
				n=n/2;
			}
			while(n%3==0)
			{
				three++;
				n=n/3;
			}
			if(n!=1 || two>three)
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println((three*2)-two);
			}
		}
	}
}
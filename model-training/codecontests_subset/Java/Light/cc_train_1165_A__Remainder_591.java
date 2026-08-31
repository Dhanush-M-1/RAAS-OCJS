import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int x = cin.nextInt();
		int y = cin.nextInt();
		String s = cin.next();
		//System.out.println(s);
		
		int count=0,t=0;
		//System.out.println();
		for(int i=s.length()-1;t<x;t++,i--)
		{
			if(t==y)
			{
				if(s.charAt(i)=='0')
					count++;
			}
			else {
				if(s.charAt(i)=='1')
					count++;
			}
		}
		
		System.out.println(count);
			
		
	}
}

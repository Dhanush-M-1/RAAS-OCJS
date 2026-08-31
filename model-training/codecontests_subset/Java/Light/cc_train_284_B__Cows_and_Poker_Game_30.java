import java.util.*;
public class CowPokerGame
{
	public static void main(String args[])
	{
		int cnt=0;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		String str = s.nextLine();
	
		int na = 0;
		int nf = 0;
		int ni = 0;
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='A')na++;
			else if(str.charAt(i)=='F')nf++;
			else ni++;
		}
		if(ni==0)cnt=na;
		else if(ni==1)cnt=1;
		else cnt=0;
		System.out.println(cnt);
	}
}


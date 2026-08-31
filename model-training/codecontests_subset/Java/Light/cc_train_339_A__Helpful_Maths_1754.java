import java.util.*;
public class helpful
{
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s,sNew="";
		int c1=0,c2=0,c3=0,l,i;
		s=x.nextLine();
		l=s.length();
		for(i=0;i<l;i++)
		{
			if(s.charAt(i)=='1')
				c1++;
			else 
			if(s.charAt(i)=='2')
				c2++;
			else
			if(s.charAt(i)=='3')
				c3++;
		}
		for(i=0;i<c1;i++)
			sNew=sNew+"1+";
		for(i=0;i<c2;i++)
			sNew=sNew+"2+";
		for(i=0;i<c3;i++)
			sNew=sNew+"3+";
		sNew=sNew.substring(0,sNew.length()-1);
		System.out.println(sNew);
	}
}
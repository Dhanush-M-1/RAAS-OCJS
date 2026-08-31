//package april19;
import java.util.*;
public class Round63A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		/*7
abacaba
*/
		int n=scn.nextInt();
		String str=scn.next();
		int isprint=0;
		int index1=0;
		int index2=0;
		for(int i=str.length()-1; i>0; i--) {
			String s1=str.charAt(i)+"";
			String s2=str.charAt(i-1)+"";
		//	System.out.println(s1.compareTo(s2));
			if(s1.compareTo(s2)<0)
			{
				index1=i-1;
				index2=i;
				isprint=1;
				break;
			}
		}
	/*	StringBuilder s=new StringBuilder("");
		for(int i=0; i<index1; i++)
		{
			s.append(str.charAt(i));
		}
		for(int i=index2; i>index1; i--)
		{
			s.append(str.charAt(i));
		}
		for(int i=index2+1; i<str.length(); i++)
		{
			s.append(str.charAt(i));
		}*/
		if(isprint==0)
		{
			System.out.println("NO");
		}
		else
		{
			System.out.println("YES");
			System.out.println((index1+1)+" "+(index2+1));
		}
	}

}

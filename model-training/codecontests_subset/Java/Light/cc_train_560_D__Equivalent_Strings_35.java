//package feb19;
import java.util.*;
public class B559 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str1=scn.next();
		String str2=scn.next();
		String ans1=check(str1);
		String ans2=check(str2);
		if(ans1.equals(ans2))
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}


	}
	public static String check(String str)
	{
	//	System.out.println("Str:"+str);
		if(str.length()%2==1)
		{
			return str;
		}
		String firsthalf=check(str.substring(0, str.length()/2));
		String secondhalf=check(str.substring(str.length()/2,str.length()));
	//	System.out.println("F:"+firsthalf+"S:"+secondhalf);
		if(firsthalf.compareTo(secondhalf)<0)
		{
			return firsthalf+secondhalf;
		}
		else
		{
			return secondhalf+firsthalf;
		}
	}

}

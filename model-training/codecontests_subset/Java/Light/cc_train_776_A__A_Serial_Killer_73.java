import java.util.*;
public class SerialKiller {

	public static void main(String args[])
	{
		String s1,s2,s3;
		int n;
		Scanner sc=new Scanner(System.in);
		s1=sc.next();
		s2=sc.next();
		n=sc.nextInt();
		System.out.println(s1+" "+s2);
		for(int i=0;i<n;i++)
		{
			s3=sc.next();
			if(s3.equals(s1))
				s1=sc.next();
			else
				s2=sc.next();
			System.out.println(s1+" "+s2);
		}
	}
}

import java.util.Scanner;

public class SerialKiller {
	static Scanner scr=new Scanner(System.in);
	public static void main(String[] args) 
	{
		String st[]=new String[2];
		st[0]=scr.next();
		st[1]=scr.next();
		int n=scr.nextInt();
		String str[]=new String[2];
		System.out.println(st[0]+" "+st[1]);
		for(int i=0;i<n;i++)
		{
			str[0]=scr.next();
			str[1]=scr.next();
			if(st[0].equals(str[0]))
			{
			System.out.println(st[1]+" "+str[1]);
			st[0]=str[1];
			}
			else
			{	System.out.println(st[0]+" "+str[1]);
			st[1]=str[1];
			
			}
		}
	}

}

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int count=0;
		sc.nextLine();
		String s=sc.nextLine();
		for(int i=0;i<s.length();i++)
		{
		    if(s.charAt(i)=='8') count++;
		}
		if(count>=n/11){System.out.println(n/11);}
		else System.out.println(count);
	}
}

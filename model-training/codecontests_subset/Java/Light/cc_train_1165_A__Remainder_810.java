import java.util.*;
public class A1165 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int x =sc.nextInt();
		int y=sc.nextInt();
		sc.nextLine();
		int c=0;
		String s = sc.nextLine();
		for(int i=0;i<x;i++)
		{
			if(i==y && s.charAt(s.length()-1-i)=='0')c++;
			else if(i!=y && s.charAt(s.length()-1-i)=='1')c++;
		}
		System.out.println(c);

	}

}

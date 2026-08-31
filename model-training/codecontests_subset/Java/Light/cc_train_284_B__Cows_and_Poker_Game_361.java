import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String s = sc.next();
		int i,a,f;
		i=a=f=0;
		for(int i1=0;i1<t;i1++)
		{
		    char ch = s.charAt(i1);
		    if(ch == 'I')
		    i++;
		    else if(ch == 'A')
		    a++;
		    else
		    f++;
		    if(i>1)
		    break;
		}
		if(i>1)
		    System.out.println("0");
		else if(i==1)
		    System.out.println("1");
		else
		    System.out.println(a);
		
	}
}

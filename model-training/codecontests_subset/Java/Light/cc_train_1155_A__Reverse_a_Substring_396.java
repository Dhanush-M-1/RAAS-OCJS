import java.util.*;
public class Solution
{
static Scanner sc=new Scanner(System.in);
public static void main(String[] args) {
	int n=sc.nextInt();
	String s=sc.next();
	int flag=0;
	for(int i=1;i<n;i++)
	{
		if(s.charAt(i)<s.charAt(i-1))
		{
			System.out.println("YES\n"+(i)+" "+(i+1));
			flag=1;
			break;
		}
	}
	if(flag==0)
	{
		System.out.println("NO");
	}

}


}
import java.util.*;
public class A{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		int n = scan.nextInt();
		StringBuilder  ot = new StringBuilder();
		ot.append(s1+" "+s2+"\n");
		for(int i = 0;i < n;i++)
		{
			String x1 = scan.next();
			String x2 = scan.next();
			if(x1.equals(s1))
			{
				ot.append(s2+" "+x2+"\n");
				s1 = x2;
			}
			else if (x1.equals(s2))
			{
				ot.append(s1+" "+x2+"\n");
				s2 = x2;
			}
		}
		System.out.println(ot);
	}
}
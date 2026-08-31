import java.util.*;
public class serialkiller{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String a=scan.next();
		String b=scan.next();
		int t=scan.nextInt();
		System.out.println(a+" "+b);
		while(t-->0){
			String c=scan.next();
			String d=scan.next();
			if(c.equals(a))
				a=d;
			else
				b=d;
			System.out.println(a+" "+b);
		}
	}
}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int c,v0,v1,a,l;
		int sum=0,day;
		c=sc.nextInt();
		v0=sc.nextInt();
		v1=sc.nextInt();
		a=sc.nextInt();
		l=sc.nextInt();
		sum=v0;
		day=1;
	//	System.out.println("sum:"+sum);
		for (;sum<c;day++)
		{
			v0+=a;
		//	System.out.println("v0:"+v0);
			if (v0>v1) v0=v1;
			sum+=v0-l;
	//		System.out.println("sum:"+sum);
		}
		System.out.print(day);
	}

}

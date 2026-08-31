import java.util.Scanner;
public class Numbers {
	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int q=s.nextInt();
	long l[]=new long[q];
	long r[]=new long[q];
	long d[]=new long[q];
	for(int i=0;i<q;i++) {
		l[i]=s.nextLong();
		r[i]=s.nextLong();
		d[i]=s.nextLong();
	}
		for(int i=0;i<q;i++) 
			if(d[i]<l[i]) System.out.println(d[i]);
			else System.out.println(d[i]*(r[i]/d[i])+d[i]);
		
		}
	
}	

	

		
	
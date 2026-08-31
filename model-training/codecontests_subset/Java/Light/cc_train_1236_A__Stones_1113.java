import java.util.Scanner;
public class stone {

	public static void main(String[] args) {	
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int []a=new int[t+1];
		int []b=new int[t+1];
		int []c=new int[t+1];
		for(int i=1;i<=t;i++) {
			a[i]=sc.nextInt(); b[i]=sc.nextInt(); c[i]=sc.nextInt();
		}
		int []count=new int[t+1];
		for(int i=1;i<=t;i++) {
		while(true) {
		if((c[i]>=2)&&(b[i]>=1)) {c[i]-=2; b[i]-=1; count[i]+=3;}
		else if((b[i]>=2)&&(a[i]>=1)) {b[i]-=2; a[i]-=1; count[i]+=3;}
		     else  break;
		}
		}
		for(int i=1;i<=t;i++)
		System.out.println(count[i]);
	}

}

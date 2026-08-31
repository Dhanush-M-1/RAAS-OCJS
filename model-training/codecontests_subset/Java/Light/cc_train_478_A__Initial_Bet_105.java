import java.util.Scanner;
public class ppp {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c[]=new int[5];
		int sum=0;
		boolean ok=true;
		for(int i=0;i<5;i++){
			int x=sc.nextInt();
			if(x==0)ok=false;
			sum+=x;
		}
		if(sum==0 || sum%5!=0)System.out.println(-1);
		else System.out.println(sum/5);
		
	}}
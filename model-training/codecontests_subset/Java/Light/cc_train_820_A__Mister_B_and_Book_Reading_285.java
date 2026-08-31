import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt(),v0=sc.nextInt(),v1=sc.nextInt(),a=sc.nextInt(),l=sc.nextInt();
		int sum=c,i=0;
		while(1==1) {
			
			if((v0+i*a)<=v1) {
				sum-=(v0+i*a);
			}else {
				sum-=v1;
			}
			
			
			if(sum<=0) {
				System.out.println((i+1));break;
			}else {
				i++;sum+=l;
			}
		}
	}

}

import java.util.Scanner;
public class Test {
	static Scanner in =new Scanner(System.in);
	public static void main(String[] args){
		long n=in.nextInt();
		long k=in.nextInt();
		double i;
		for(i=0;k>(i*(i+1))/2;i++){
			
		}
		i-=1;
		double num=k-(i*(i+1))/2;
		long r=0;
		for(int z=1;z<=n;z++){
			long temp=in.nextLong();
			if(z==num)r=temp;
		}
		System.out.println(r);
	}
}
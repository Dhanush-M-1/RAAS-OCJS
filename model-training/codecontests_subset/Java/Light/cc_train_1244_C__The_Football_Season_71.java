import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int flag=0;
		long n = input.nextLong();
		long p = input.nextLong();
		long w = input.nextLong();		
		long d = input.nextLong();
		for(long i=0;i<w;i++) {
			if(((p-i*d)%w==0)&&((p-i*d)/w>=0)&&(n-i-(p-i*d)/w>=0)) {
				long x=(p-i*d)/w;
				long y=i;
				long z=n-x-y;
				System.out.println(x+" "+y+" "+z);
				flag=1;
				break;
			}
		}
		if(flag==0)
			System.out.println("-1");
	}
}

		 		  					    	 				 		     	
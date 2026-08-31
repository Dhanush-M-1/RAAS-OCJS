import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a =0;
		long n = sc.nextLong();
		long p = sc.nextLong();
		long w = sc.nextLong();
		long d = sc.nextLong();
		for(long i=0;i<w;i++){
			if(((p-i*d)%w==0)&&((p-i*d)/w>=0)&&(n-i-(p-i*d)/w>=0)){
				long x=(p-i*d)/w;
				long y=i;
				long z=n-x-y;
				System.out.println(x+" "+y+" "+z);
				a=1;
				break;
			}
		}
		if(a==0){
			System.out.println("-1");
		}

	}
}
	 		 				  		      	 	  	    		
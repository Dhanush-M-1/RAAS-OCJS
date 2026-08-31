public class Candles{
	public static void main(String []args){
		
		java.util.Scanner scan=new java.util.Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int count=0,rem=0;
		while(a>0){
			//System.out.println("a: "+a+" rem: "+rem+" count: "+count);
			count+=a;
			rem+=a%b;
			a/=b;
			if(rem>=b){
				a+=rem/b;
				rem=rem%b;
			}
		}
		System.out.println(count);
		
	}
}
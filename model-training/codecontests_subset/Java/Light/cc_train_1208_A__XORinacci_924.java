public class Xor{
	static int res(int a,int b,int n){
		int r=n%3;
		
		switch(r){
			case 0:
			return a;
			
			case 1:
			return b;
			
			case 2:
			return a^b;
			
			
		}
		return -1;
		}
	public static void main(String args[]){
		java.util.Scanner scan=new java.util.Scanner(System.in);
		int t=scan.nextInt();
		
			
		for(int c=0;c<t;c++){
			int a=scan.nextInt();
			int b=scan.nextInt();
			int n=scan.nextInt();
			System.out.println(res(a,b,n));
		}
		
}
}
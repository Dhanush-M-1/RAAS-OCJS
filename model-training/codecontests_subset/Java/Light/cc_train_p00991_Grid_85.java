import java.util.*;
import java.math.*;
class Main{
	static final int M=100000007;
	public static int comb(int n,int c){
		BigInteger b=BigInteger.ONE;
		for(int i=0;i<c;i++){
			b=b.multiply(new BigInteger(String.valueOf(n-i))).divide(new BigInteger(String.valueOf(i+1)));
		}
		return b.mod(new BigInteger(String.valueOf(M))).intValue();
	}
	public static void main(String[]Z){
		Scanner cin=new Scanner(System.in);
		int r=cin.nextInt(),c=cin.nextInt(),a1=cin.nextInt(),a2=cin.nextInt(),b1=cin.nextInt(),b2=cin.nextInt();
		int x=Math.abs(a1-b1),y=Math.abs(a2-b2);
		x=Math.min(x,r-x);y=Math.min(y,c-y);
		int z=1;
		if(x==r-x)z*=2;
		if(y==c-y)z*=2;
		System.out.println(z*comb(x+y,Math.min(x,y))%M);
	}
}
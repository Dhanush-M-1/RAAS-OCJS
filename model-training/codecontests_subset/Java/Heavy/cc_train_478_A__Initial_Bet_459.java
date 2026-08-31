import java.util.*;
public class InitialBet {
	public static int getsum(int x1,int x2,int x3,int x4,int x5) {
		int s=x1+x2+x3+x4+x5;
		return s;
	}
	public static void main (String []args) {
		Scanner f=new Scanner(System.in);
		boolean y=true;
		int a=f.nextInt();
		int b=f.nextInt();
		int c=f.nextInt();
		int d=f.nextInt();
		int e=f.nextInt();
		int []v={a,b,c,d,e};
		int q=0;
		int s=getsum(a,b,c,d,e);
		for(int i=1;i<s;i++) {
			if(s%i==0) {
				for(int j=0;j<5;j++) {
				//	if(v[j]>i)
						q+=(v[j]-i);
					//else
						//q-=(v[j]/i);
				}
			if(q==0) {
				System.out.println(i);
				y=false;
				break;
				}
			}
			q=0;
		}
if(y)
	System.out.println(-1);
	}
}
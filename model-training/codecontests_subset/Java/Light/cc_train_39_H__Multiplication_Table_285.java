//package first;//提交代码时，此行要注释掉
import java.math.BigDecimal;//小数
import java.math.BigInteger;//整数
import java.util.*;
public class Main{
	static int N =101010;
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n,m,k,ans;
		k = cin.nextInt();
		n = k;
		for(int i = 1;i<n;i++) {
			for(int j =1;j<n;j++) {
				m =i*j;
				System.out.print(solve(m,k)+" ");
			}
	   System.out.println();
	}
	}
	public static int solve(int m,int k) {
		int s = 0, i = 0,a[] =new int[N];
		while(true) {
			a[++i]=m%k;
			m /=k;
			if(m==0)
				break;
		}
		for(int j = i;j >=1;j--)
			s=s*10+a[j];
		return s;
		
	}
	
}

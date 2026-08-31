import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.util.Comparator;


public class F2{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] dp = new long[10];
		
		long[] dp2 = dp;
		Arrays.fill(dp,-1);
		dp[0] = 0;
		Comparator<Long> comp = new Comparator<Long>(){
			public int compare(Long a, Long b){
				return Long.compare(b,a);
			}};
		for(int i = 0;i<n;++i){
			int k = in.nextInt();
			long max3 = 0;
			long max2 = 0;
			Vector<Long> ones = new Vector<Long>();
			for(int j = 0;j<k;++j){
				int c = in.nextInt();
				if(c == 1) ones.add(in.nextLong());
				if(c == 2) max2 = Math.max(max2,in.nextLong());
				if(c==3) max3 = Math.max(max3,in.nextLong());
			}
			ones.sort(comp);
			long x1 = 0;
			long x2 = 0; long y2 = 0;
			long x3 = 0; long y3 = 0;
			if(max3!=0) x1 = Math.max(x1,max3);
			if(ones.size()>0) x1 = Math.max(x1,ones.get(0));
			if(max2 != 0){ x1 = Math.max(x1,max2);
				if(ones.size()>0){
					x2 = max2+ones.get(0);
					y2 = Math.max(max2,ones.get(0));
				}
			}
			if(ones.size()>=2 && x2 < ones.get(0)+ones.get(1)){
				x2 = ones.get(0)+ones.get(1);
				y2 = ones.get(0);
			}
			if(ones.size()>=3){
				x3 = ones.get(0)+ones.get(1) + ones.get(2);
				y3 = ones.get(0);
			}
			dp2 = dp;
			dp = Arrays.copyOf(dp2,10);
			for(int j = 0;j<10;++j){
				if(dp2[j] == -1) continue;
				if(x1>0) dp[(j+1)%10] = Math.max(dp[(j+1)%10], dp2[j] + x1 + ((j+1)>=10 ? x1:0));
				if(x2>0) dp[(j+2)%10] = Math.max(dp[(j+2)%10], dp2[j] + x2 + ((j+2)>=10 ? y2:0));
				if(x3>0) dp[(j+3)%10] = Math.max(dp[(j+3)%10], dp2[j] + x3 + ((j+3)>=10 ? y3:0));
			}
			//System.out.println(Arrays.toString(dp));

		}
		long res = 0;
		for(int i = 0;i<=9;++i)
			res = Math.max(dp[i],res);
		System.out.println(res);


	}
}

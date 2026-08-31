import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] array;
	static double e=0.000000000009;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int naux = n;
		array = new int[n];
		Set<Integer> set=new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			set.add(array[i]);
		}
		if (set.size()==1){ System.out.printf(Locale.US,"%.15f\n",0.0);return;}
		double res=check(ts(-20000,20000,100));
		System.out.printf(Locale.US,"%.15f\n",res);
	}
	
	static double ts(double l, double r,int its){
		if (its==0) return l;
		double middle = (l+r)/2;
		double check1=check(middle);
		double check0=check(middle-e);
		if(check0 > check1){
			return ts(middle,r,its-1);
		}
		else if(check0 < check1){
			return ts(l,middle,its-1);
		}
		return middle;
	}

	private static double check(double d) {
		double[] dp1=new double[n+1];
		double[] dp2=new double[n+1];
		double[] a=new double[n];
		for (int i = 0; i < n; i++) {
			a[i]=array[i]+d;
		}
		for (int i = n-1; i >= 0; i--) {
			dp1[i]=a[i]+dp1[i+1];
			dp2[i]=a[i]+dp2[i+1];
			if (dp1[i]<0){
				dp1[i]=0;
			}
			else if (dp2[i]>0){
				dp2[i]=0;
			}
		}
		double max=0;
		double min=0;
		for (int i = 0; i < n; i++) {
			max=Math.max(max, dp1[i]);
			min=Math.min(min, dp2[i]);
		}
		min*=-1;
		return Math.max(max, min);
	}
}

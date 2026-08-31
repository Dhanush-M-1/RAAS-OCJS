import java.util.Scanner;

public class D621 {
	public static boolean approx(double x, double y){
		return Math.abs(x-y) < .000000001;
	}
	public static int asd(int x, int y){
		if(x<y) return 0;
		return 1;
	}
	public static void main(String args[]){
		String[] out = {"x^y^z", "x^z^y", "(x^y)^z", "y^x^z", "y^z^x", "(y^x)^z", "z^x^y", "z^y^x", "(z^x)^y"};
		Scanner sc = new Scanner(System.in);
		double[] x = new double[3];
		double[] a = new double[3];
		int[] index = new int[3];
		for(int i=0;i<3;++i) index[i] = 3;
		for(int i=0;i<3;++i) x[i] = sc.nextDouble();
		for(int i=0;i<3;++i){
			int j = Math.min((i+1)%3, (i+2)%3);
			int k = Math.max((i+1)%3, (i+2)%3);
			if(x[i] <= 1){
				a[i] = Math.min(x[j]*Math.log(x[k]), Math.min(x[k]*Math.log(x[j]), Math.log(x[j]*x[k])));
			}
			else{
				a[i] = Math.max(x[j]*Math.log(x[k]), Math.max(x[k]*Math.log(x[j]), Math.log(x[j]*x[k])));
			}
			if(approx(a[i], Math.log(x[j]*x[k]))) index[i] = 2;
			if(approx(a[i], x[k]*Math.log(x[j]))) index[i] = asd(j,k);
			if(approx(a[i], x[j]*Math.log(x[k]))) index[i] = Math.min(asd(k,j),index[i]);
		}
		boolean[] less1 = new boolean[3];
		int num = 0;
		int ret = 0;
		for(int i=0;i<3;++i) if(x[i] <= 1){
			num++;
			less1[i] = true;
		}
		
		double[] log2 = new double[3];
		if(num == 3){
			for(int i=0;i<3;++i) if(x[i] == 1.0){
				System.out.println(out[3*i]);
				System.exit(0);
			}
			for(int i=0;i<3;++i) log2[i] = a[i]+Math.log(-Math.log(x[i]));
			double min = Double.MAX_VALUE;
			for(int i=0;i<3;++i) min = Math.min(min, log2[i]);
			for(int i=2;i>=0;--i) if(approx(min, log2[i])) ret = i;
			System.out.println(out[3*ret+index[ret]]);
		}
		else{
			for(int i=0;i<3;++i){
				if(!less1[i]){
					log2[i] = a[i]+Math.log(Math.log(x[i]));
				}
				else log2[i] = -Double.MAX_VALUE;
			}
			double max = -Double.MAX_VALUE;
			for(int i=0;i<3;++i) max = Math.max(max, log2[i]);
			for(int i=2;i>=0;--i) if(approx(max, log2[i])) ret = i;
			System.out.println(out[3*ret+index[ret]]);
		}
	}
}

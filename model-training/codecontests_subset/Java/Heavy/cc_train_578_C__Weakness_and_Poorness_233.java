import java.util.Scanner;

public class weakpoor {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		double[] a=new double[n];
		for(int i=0;i<n;i++) a[i]=scan.nextInt();
		
		double l = -(1e9 + 3), r = 1e9 + 3;
	    for(int i = 0; i < 200; ++i){
	        double g1 = (l * 2 + r) / 3;
	        double g2 = (l + r * 2) / 3;
	        
	        if(go(a,g1) > go(a,g2)) l = g1;
	        else r = g2;
	    }
	    
	    System.out.println(go(a,l));
	    
	    
	}
	public static double go(double[] a, double x) {
		double max=0, min=0;
		double maxStreak=0, minStreak=0;
		
		for(int i=0;i<a.length;i++) {
			maxStreak+=a[i]-x;
			minStreak+=a[i]-x;
			
			if(maxStreak<0) maxStreak=0;
			if(minStreak>0) minStreak=0;
			
			max=Math.max(max,maxStreak);
			min=Math.min(min,minStreak);
		}
		return Math.max(max,-min);
	}
}
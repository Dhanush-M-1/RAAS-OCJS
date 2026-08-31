import java.util.*;
public class BeerANDraspberry {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int c=sc.nextInt();
		int d[]=new int[n];
		for(int i=0;i<n;i++) {
			d[i]=sc.nextInt();
		}
		int t[]=new int[n-1];
		for(int i=0;i<n-1;i++) {
			t[i]=d[i]-d[i+1];
		}
		int max=-1000000;
		for(int i=0;i<n-1;i++) {
			if(t[i]>max)
				max=t[i];
		}
		if((max-c)>0) {
			System.out.println(max-c);
		}
		else
			System.out.println(0);
			

	}

}

import java.util.*;

public class spi{
	public static void main(String ... args){
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
    		b[i]=in.nextInt();
		}
		int c=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(b[i]==a[j]){c++;
				}
			}
		}
		System.out.println(c);
	}
}

/**

	int binarySearch(int from, int to) {
		while (from<to) {
			int x=(from+to)/2;
			if (f(x)) to=x;
			else from=x+1;
		}
		return from;
	} 

*/
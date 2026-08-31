import java.util.Arrays;
import java.util.Scanner;


public class C545 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
	//	tree a[]= new tree[n];
		int a[][]=new int[n][2];
		for(int i=0;i<n;i++){
			a[i][0]=in.nextInt();
			a[i][1]=in.nextInt();
			//a[i]= new tree(in.nextInt(),in.nextInt());
		}
		//Arrays.sort(a);
		long c=a[0][0]-a[0][1]-1;
		long out=0;
		for(int i=0;i<n-1;i++){
			if( a[i][0]-a[i][1] >c){
				c=a[i][0];
				out++;
			}
			else if( a[i][0]+a[i][1]<a[i+1][0]){
				out++;
				c=a[i][0]+a[i][1];
			}
			else
				c=a[i][0];
		}
		
		System.out.println(++out);
		
		
	}
}
class tree implements Comparable<tree>{
	int x;
	int h;
	public tree(int xx, int hh){
		x=xx;
		h=hh;
	}
	@Override
	public int compareTo(tree o) {
		// TODO Auto-generated method stub
		return x-o.x;
	}
}
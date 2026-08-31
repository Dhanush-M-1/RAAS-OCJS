import java.util.*;

public class B {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int x=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		int mid=n/2;
		if(a[mid]==x) {
			System.out.println(0);
			return;
		}
		long count=0;
		if(a[mid]>x) {
			while(mid>=0&&a[mid]>x) {
				count=count+a[mid]-x;
				mid=mid-1;
			}
		}
		else {
			while(mid<n&&a[mid]<x) {
				count=count-a[mid]+x;
				mid=mid+1;
			}
		}
		System.out.println(count);
	}

}

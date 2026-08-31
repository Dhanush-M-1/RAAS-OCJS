import java.util.*;
public class prac1 {
	static ArrayList<Integer> freq(int a[]){
		ArrayList<Integer> arr=new ArrayList<>();
		int n=a.length;
		int prev=a[0];
		int ctr=0;
		for(int i=0;i<n;i++) {
			if(prev==a[i]) {
				ctr++;
			}
			else {
				prev=a[i];
				arr.add(ctr);
				ctr=1;
			}
		}
		arr.add(ctr);
		return arr;
	}
	public static void main(String args[]) {
		Scanner in=new Scanner (System.in);
		int t=in.nextInt();
		while(--t>=0) {
			int n=in.nextInt();
			int a[]=new int[n];
			int x=0,y=0,z=0;
			for(int i=0;i<n;i++) {
				a[i]=in.nextInt();
			}
			
			ArrayList<Integer> arr=freq(a);
			
			int g=0,s=0,b=0,i;
			int len=arr.size();
			g=arr.get(0);
			for(i=1;i<len;i++) {
				s=s+arr.get(i);
				if(s>g)
					break;
			}
			int index=i+1;
			int sum=g+s;
			for(i=index;i<len;i++) {
				if(sum+arr.get(i)<=n/2) {
					sum=sum+arr.get(i);
				}
				else {
					break;
				}
			}
			b=sum-(g+s);
			if(g>0 && s>0 && b>0 && g<s && g<b) {
				System.out.println(g+" "+s+" "+b);
			}
			else {
				System.out.println("0 0 0");
			}
		}
	}
}

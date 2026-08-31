import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int q=sc.nextInt();
		int[] a=new int[n];
		for(int i=0; i<n; i++){
			a[i]=sc.nextInt();
		}
		long ans=1000000000;
		PriorityQueue<Integer> small = new PriorityQueue<>(), big = new PriorityQueue<>();
		for(int i=0; i<n; i++){
			int left=0;
			big.clear();
			while(left<n){
				while(left<n && a[left]<a[i]){
					left++;
				}
				small.clear();
				while(left<n && a[left]>=a[i]){
					small.add(a[left++]);
				}
				while(small.size()>=k){
					big.add(small.poll());
				}
			}
			if(big.size()<q){
				continue;
			}
			for(int j=1; j<q; j++){
				big.poll();
			}
			ans=Math.min(ans,big.peek()-a[i]);
		}
		System.out.println(ans);
	}
}

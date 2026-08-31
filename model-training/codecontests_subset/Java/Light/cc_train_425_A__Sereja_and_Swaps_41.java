import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {

	static int n,k;
	static int[]a;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		a=new int[n];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=i+1;j<=n;j++){
				PriorityQueue<Integer>q1=new PriorityQueue<Integer>();
				PriorityQueue<Integer>q2=new PriorityQueue<Integer>();
				List<Integer>l1,l2;
				l1=new ArrayList<Integer>();
				l2=new ArrayList<Integer>();
				int sum = addALL(q1,q2,i,j);
				for(int cnt=0;cnt<k && !q1.isEmpty();cnt++){
					l1.add(q1.poll());
				}
				for(int cnt=0;cnt<k && !q2.isEmpty();cnt++){
					l2.add(-q2.poll());
				}
				for(int cnt=0;cnt<k;cnt++){
					if(l1.size()==cnt ||l2.size()==cnt)break;
					if(l1.get(cnt) > l2.get(cnt))break;
						
					sum -=l1.get(cnt);
					sum +=l2.get(cnt);
				}
				max=Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
	static int addALL(PriorityQueue<Integer>q1,PriorityQueue<Integer>q2,int low,int high){
		int res=0;
		for(int i=0;i<a.length;i++){
			if(low<=i&&i<high){
				q1.add(a[i]);
				res+=a[i];
			}
			else{
				q2.add(-a[i]);
			}
		}
		return res;
	}
}

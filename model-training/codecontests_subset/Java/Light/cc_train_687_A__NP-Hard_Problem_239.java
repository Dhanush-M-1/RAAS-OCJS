import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A687 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<n;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0;i<m;i++){
			int v1 = sc.nextInt()-1;
			int v2 = sc.nextInt()-1;
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		int[] flags = new int [n+10];
		for(int i=0;i<n;i++)
			flags[i]=0;
		for(int k=0;k<n;k++){
			if(flags[k]==0 & graph.get(k).size()!=0){
				q.add(k);
				flags[k] = 1;
				while(!q.isEmpty()){
					int v = q.poll();
					int color = (flags[v]==1)?2:1;
					for(int i=0;i<graph.get(v).size();i++){
						if(flags[graph.get(v).get(i)]!=0 && flags[graph.get(v).get(i)]!=color){
							System.out.println(-1);
							return;
						}else if(flags[graph.get(v).get(i)]==0){
							flags[graph.get(v).get(i)] = color;
							q.add(graph.get(v).get(i));
						}
					}
				}
			}
		}
		int one = 0, two = 0;
		for(int i=0;i<n;i++){
			if(flags[i]==1)
				one++;
			if(flags[i]==2)
				two++;
		}
		System.out.println(one);
		for(int i=0;i<n;i++)
			if(flags[i]==1)
				System.out.print((i+1)+" ");
		System.out.println();
		System.out.println(two);
		for(int i=0;i<n;i++)
			if(flags[i]==2)
				System.out.print((i+1)+" ");
		sc.close();
	}
}
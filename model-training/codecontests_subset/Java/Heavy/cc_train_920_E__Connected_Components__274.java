import java.util.*;
import java.io.*;

public class Solution{

	public static Integer INT(String s) {
		return Integer.parseInt(s);
	}
	public static Long LONG(String s) {
		return Long.parseLong(s);
	}

	static int mod=1_000_000_007, oo=Integer.MAX_VALUE, _oo=Integer.MAX_VALUE;

	//==================================================================================================================================================



	public static void main(String args[]) throws IOException {
 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	Scanner in=new Scanner(System.in); StringBuilder out=new StringBuilder();

		int n=in.nextInt(),
			k=in.nextInt();

		HashSet<Integer> set[]=new HashSet[n];
		for(int i=0; i<n; i++)
			set[i]=new HashSet<>();

		for(int i=0; i<k; i++) {
			int u=in.nextInt()-1,
				v=in.nextInt()-1;
			set[u].add(v);
			set[v].add(u);
		}

		LinkedList<Integer> avail=new LinkedList<>();
		for(int i=0; i<n; i++)
			avail.add(i);

		int cnt=0;
		Queue<Integer> q=new ArrayDeque<>();

		int visited[]=new int[n];

		while(!avail.isEmpty()) {

			q.add(avail.removeFirst());
			cnt+=1;

			while(!q.isEmpty()) {
				int item=q.poll(),
					size=avail.size();
				visited[item]=cnt;
				for(int i=0; i<size; i++) {
					int temp=avail.removeFirst();
					if(!set[item].contains(temp))
						q.add(temp);
					else
						avail.add(temp);
				}
			}
		}

		HashMap<Integer, Integer> map=new HashMap<>();
		for(int item: visited)
			map.put(item, map.getOrDefault(item, 0)+1);

		ArrayList<Integer> list=new ArrayList<>(map.values());
		Collections.sort(list);
		out.append(cnt+"\n");
		for(int item: list)
			out.append(item+" ");

		System.out.print(out);
	}
}
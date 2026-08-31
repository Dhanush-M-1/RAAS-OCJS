import java.util.*;
import java.io.*;
public class Main {
static ArrayList<Integer>list[];
static byte visited[];
static ArrayList<Integer>vertex;
public static void main(String [] args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int array[] = new int[n + 1];
	st = new StringTokenizer(br.readLine());
	for(int i = 1;i <= n;i++)
		array[i] = Integer.parseInt(st.nextToken());
 
	list = new ArrayList[n + 1];
	for(int i = 1;i <= n;i++)
		list[i] = new ArrayList<Integer>();
	for(int i = 1;i <= m;i++){
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		list[a].add(b);
		list[b].add(a);
	}
	visited = new byte[n + 1];
	Integer [] values;
	for(int i = 1;i <= n;i++){
		if(visited[i] == 1)continue;
		vertex = new ArrayList<Integer>();
	   Queue<Integer>q = new LinkedList<Integer>();
	   q.add(i);
	   while(!q.isEmpty()){
	  	int node = q.poll();
	  	if(visited[node] == 1)continue;
	  	visited[node] = 1;
	  	vertex.add(node);
	  	for(int temp : list[node])
	  	if(visited[temp] == 0)
	  	       q.add(temp);
	  }
	  //System.out.println(vertex);
		values = new Integer[vertex.size()];
		for(int j = 0;j < vertex.size();j++)
			values[j] = array[vertex.get(j)];
		Arrays.sort(values);
		Collections.sort(vertex);
		for(int j = 0;j < vertex.size();j++)
			array[vertex.get(j)] = values[vertex.size() - j - 1];
	}
	StringBuilder sb = new StringBuilder();
	for(int i = 1;i <= n;i++)
				sb.append(array[i] + " ");
				System.out.print(sb);
}
}
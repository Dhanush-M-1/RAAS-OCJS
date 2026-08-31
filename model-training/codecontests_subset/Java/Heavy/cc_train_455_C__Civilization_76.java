import java.io.*;
import java.util.*;


public class C
{
	private static int [] parents;
	private static int dis;
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int q = Integer.parseInt(tokenizer.nextToken());

		ArrayList<Integer> [] graph = new ArrayList[n];
		for(int i = 0 ; i < n ; i++)
			graph[i] = new ArrayList<Integer>();

		for(int i = 0 ; i < m ; i++)
		{
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken()) - 1;
			int b = Integer.parseInt(tokenizer.nextToken()) - 1;

			graph[a].add(b);
			graph[b].add(a);
		}

		parents = new int[n];
		for(int i = 0 ; i < n ; i++)
			parents[i] = i;

		int [] lefts = new int[n];
		int [] rights = new int[n];
		int [] distances = new int[n];

		int [] visited = new int[n];
		int [] best = new int[n];
		Arrays.fill(best, Integer.MAX_VALUE/2);
		int idx = 1;
		for(int i = 0 ; i < n ; i++)
			if(visited[i] == 0)
			{
				int left = bfs1(i, graph, visited, best, idx);
				int right = bfs2(left, graph, visited, best, idx);

				lefts[set(i)] = left;
				rights[set(i)] = right;
				distances[set(i)] = dis;

				idx++;
			}


		while(q-- > 0)
		{
			tokenizer = new StringTokenizer(reader.readLine());
			int type = Integer.parseInt(tokenizer.nextToken());

			if(type == 1)
			{
				int x = Integer.parseInt(tokenizer.nextToken()) - 1;
				writer.println(distances[set(x)]);
			}
			else
			{
				int x = Integer.parseInt(tokenizer.nextToken()) - 1;
				int y = Integer.parseInt(tokenizer.nextToken()) - 1;
				if(set(x) != set(y))
				{
					int nLeft = lefts[set(x)];
					int nRight = rights[set(y)];
					int nDis = (distances[set(x)] + 1)/2 + (distances[set(y)] + 1)/2 + 1;

					int l1 = lefts[set(x)];
					int r1 = rights[set(x)];
					int d1 = distances[set(x)];

					int l2 = lefts[set(y)];
					int r2 = rights[set(y)];
					int d2 = distances[set(y)];

					parents[set(x)] = set(y);

					if(d1 > nDis)
					{
						nDis = d1;
						nLeft = l1;
						nRight = r1;
					}
					if(d2 > nDis)
					{
						nDis = d2;
						nLeft = l2;
						nRight = r2;
					}

					lefts[set(x)] = nLeft;
					rights[set(x)] = nRight;
					distances[set(x)] = nDis;
				}
			}
		}

		writer.flush();
		writer.close();
	}

	private static int set(int a)
	{
		return parents[a] == a ? a : (parents[a] = set(parents[a]));
	}

	private static int bfs1(int st, ArrayList<Integer>[] graph, int [] visited, int [] best, int idx)
	{
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(st);
		visited[st] = idx;
		best[st] = 0;

		ArrayList<Integer> seen = new ArrayList<Integer>();

		int res = st;

		while(!queue.isEmpty())
		{
			int at = queue.poll();
			seen.add(at);
			for(int to : graph[at])
			{
				if(visited[to] == 0)
				{
					if(set(to) != set(st))
						parents[set(to)] = set(st);
					best[to] = best[at] + 1;
					if(best[to] > best[res])
						res = to;
					queue.offer(to);
					visited[to] = idx;
				}
			}
		}
		for(int next : seen)
		{
			visited[next] = 0;
			best[next] = Integer.MAX_VALUE/2;
		}

		return res;
	}

	private static int bfs2(int st, ArrayList<Integer>[] graph, int [] visited, int [] best, int idx)
	{
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(st);
		visited[st] = idx;
		best[st] = 0;


		int res = st;

		while(!queue.isEmpty())
		{
			int at = queue.poll();

			for(int to : graph[at])
			{
				if(visited[to] == 0)
				{
					best[to] = best[at] + 1;
					if(best[to] > best[res])
						res = to;
					queue.offer(to);
					visited[to] = idx;
				}
			}
		}

		dis = best[res];
		return res;
	}


}

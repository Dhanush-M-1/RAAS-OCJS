import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author jasonsun0310
 */
public class Main {
	public static void main(String[] args)
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		D solver = new D();
		solver.solve(1, in, out);
		out.close();
	}

	static @SuppressWarnings("ALL")
	class D {
		private static final int MAXN = 100000+5;
		private int n;
		private int m;
		private int[]        vertexWeights = new int[MAXN];
		private boolean[]    vis           = new boolean[MAXN];
		private List<Edge>[] edges         = new List[MAXN];

		public void solve(int testNumber, InputReader in, OutputWriter out)
		{
			initialize(in, out);
			for(int i = 0; i < n; i++)
				if(!vis[i]) dfs(i);
			if(!ok())
				out.build("No\n");
			else
				out.build("Yes\n");
			out.done();
		}

		private void dfs(int u)
		{
			vis[u] = true;
			for(Edge e : edges[u])
			{
				int v = e.to;
				if(vis[v]) continue;
				vertexWeights[v] = vertexWeights[u]+e.cost;
				dfs(v);
			}
		}

		private boolean ok()
		{
			for(int i = 0; i < n; i++)
				for(Edge e : edges[i])
					if(vertexWeights[e.to]-vertexWeights[i] != e.cost)
						return false;
			return true;
		}

		private void initialize(InputReader in, OutputWriter out)
		{
			n = in.readInt();
			m = in.readInt();
			ArrayUtils.fill(edges, ArrayUtils.range(0, n), () -> new ArrayList<Edge>());
			ArrayUtils.fill(vis, 0, n, false);
			ArrayUtils.fill(vertexWeights, 0, n, 0);
			for(int i = 1; i <= m; i++)
			{
				int l = in.readInt()-1;
				int r = in.readInt()-1;
				int d = in.readInt();
				edges[l].add(new Edge(r, d));
				edges[r].add(new Edge(l, -d));
			}
		}

		private class Edge {
			int to;
			int cost;

			public Edge(int to, int cost)
			{
				this.to = to;
				this.cost = cost;
			}
		}
	}

	static @SuppressWarnings("ALL")
	class InputReader {
		final private int BUFFER_SIZE = 1<<16;
		private BufferedInputStream din;
		private byte[]              buffer;
		private int                 bufferPointer;
		private int                 bytesRead;

		public InputReader(InputStream stream)
		{
			din = new BufferedInputStream(stream);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public InputReader(String file_name)
		{
			try
			{
				din = new BufferedInputStream(new FileInputStream(file_name));
			} catch(Exception e)
			{
				throw new InputMismatchException();
			}
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public int readInt()
		{
			int ret = 0;
			byte c = read();
			while(c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if(neg)
				c = read();
			do
			{
				ret = ret*10+c-'0';
			} while((c = read()) >= '0' && c <= '9');

			if(neg)
				return -ret;
			return ret;
		}

		private void fillBuffer()
		{
			try
			{
				bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			} catch(Exception e)
			{
				throw new InputMismatchException();
			}
			if(bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read()
		{
			if(bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
	}

	static @SuppressWarnings("ALL")
	class ArrayUtils {
		public static int[] range(int a, int b)
		{
			return new int[]{a, b};
		}

		public static void fill(int[] arr, int from, int to, int val)
		{
			int len = to-from+1;
			arr[from] = val;
			for(int i = 1; i < len; i += i)
				System.arraycopy(arr, from, arr, from+i, ((len-i) < i) ? (len-i) : i);
		}

		public static void fill(boolean[] arr, int from, int to, boolean val)
		{
			int len = to-from+1;
			arr[from] = val;
			for(int i = 1; i < len; i += i)
				System.arraycopy(arr, from, arr, from+i, ((len-i) < i) ? (len-i) : i);
		}

		public static <T> void fill(List<T>[] list, int[] rangeDim1, Supplier<List<T>> function)
		{
			for(int i = rangeDim1[0]; i <= rangeDim1[1]; i++)
				list[i] = function.get();
		}
	}

	static class OutputWriter {
		private final PrintWriter writer;
		private static StringBuilder builder = new StringBuilder();

		public void done()
		{
			print(builder);
			builder.setLength(0);
		}

		public OutputWriter build(String s)
		{
			builder.append(s);
			return this;
		}

		public OutputWriter(OutputStream outputStream)
		{
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer)
		{
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects)
		{
			for(int i = 0; i < objects.length; i++)
			{
				if(i != 0)
				{
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
		}

		public void close()
		{
			writer.close();
		}
	}
}
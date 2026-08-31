import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class TestClass {

	/**
	 * @param args
	 */
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		Node node[] = new Node[(int)n];
		for(int z=0;z<n;z++)
		{
			String s[] = in.readLine().split(" ");
			node[z] = new Node(Long.parseLong(s[0]),Long.parseLong(s[1]));
		}
		if(n==1)
		{
			out.println(1);
			out.close();
			System.exit(0);
		}
		long c=2;
		for(int i=1;i<n-1;i++)
		{
			if(node[i].x-node[i-1].x>node[i].h)
			{
				c++;
			}
			else if(i+1<n && node[i+1].x-node[i].x>node[i].h)
			{
				c++;
				node[i].x = node[i].x + node[i].h;
			}
		}
		out.println(c);
		out.close();
	}

}
class Node
{
	long x,h;
	Node(long x,long h)
	{
		this.x=x;
		this.h=h;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D {
	
	public static void main(String[] args) throws Exception
	{
		new D().run();
	}
	
	LinkedList<Integer> inversionLocations = new LinkedList<Integer>();
	int K;
	int inversions;
	char[] chars;
	ArrayList<Integer> toAdd = new ArrayList<Integer>();
	
	public void run() throws Exception
	{
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(file.readLine());
		int T = Integer.parseInt(st.nextToken());
		PrintWriter pout = new PrintWriter(System.out);
		for(int z = 0;z<T;z++)
		{
			st = new StringTokenizer(file.readLine());
			long K = Long.parseLong(st.nextToken());
			long L = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			StringBuilder sb = new StringBuilder("");
			for(long i = L;i<=R;i++)
			{
				sb.append(getIndex(K,i-1));
				sb.append(" ");
			}
			pout.println(sb.toString());
		}
		pout.flush();
	}
	
	public long getIndex(long K, long index)
	{
		if(index == K*(K-1))
			return 1;
		 return getIndexHelper(K, index);
		
	}
	
	public long blockSum(long K, long x)
	{
		if(x == 0)
			return 0;
		long first = (K-1)*2;
		long last = (K-x)*2;
		long terms = ((first - last)/2)+1;
		return (first + last) * terms/2;
	}
	
	public int getBlock(long K, long index)
	{
		long L = 0;
		long R = K+1;
		long M = (R+L)/2;
		long ceil = K+1;
		while(R-L > 1)
		{
			M = ((R+L)/2);
			long sum = blockSum(K, M);
			//System.out.println(L+" "+R+" "+M);
			if(sum >= index)
			{
				ceil = M;
				R = M;
			}else {
				L = M;
			}
		}
		return (int)(ceil);
	}
	
	public long getIndexHelper(long K, long index)
	{
		int block = getBlock(K, index+1)-1;
		//System.out.println(index+"_"+block);
		//System.out.println("K = "+K+", index "+index+" block is "+block);
		long remaining = index - blockSum(K, block);
		//System.out.println("remaining: " + remaining);
		if((remaining & 1) == 0)
			return block+1;
		return (block+1) + (remaining/2 + 1);

	}
	
}

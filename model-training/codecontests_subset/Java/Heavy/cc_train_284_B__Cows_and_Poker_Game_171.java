import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CFTest31
{

	static BufferedReader br;
	
	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));
	
		try {
		
			int n=readInt();
			
			String s=readLine();
			br.close();
			
			int ni=0;
			int na=0;
			for(int i=0;i<n;i++){if(s.charAt(i)=='A')na++;
			else if(s.charAt(i)=='I')ni++;
			}
			
			if(ni==1)System.out.println(1);
			else if(ni>1)System.out.println(0);
			else System.out.println(na);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	
	
	static public String readLine() throws IOException {
		return br.readLine();

	}

	

	static public String readString() throws IOException {
		return br.readLine();

	}

	static public long readlong() throws IOException {
		return Long.parseLong(br.readLine());
	}

	static public int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static public int[] readIntArr() throws IOException {
		String[] str = br.readLine().split(" ");
		int arr[] = new int[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(str[i]);
		return arr;
	}

	static public double[] readDoubleArr() throws IOException {
		String[] str = br.readLine().split(" ");
		double arr[] = new double[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Double.parseDouble(str[i]);
		return arr;
	}

	static public long[] readLongArr() throws IOException {
		String[] str = br.readLine().split(" ");
		long arr[] = new long[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Long.parseLong(str[i]);
		return arr;
	}

	static public double readDouble() throws IOException {
		return Double.parseDouble(br.readLine());
	}
}

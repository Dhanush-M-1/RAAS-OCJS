import java.util.*;
import java.io.*;
public class XORincci{

	static int compute(int A[], int n)
	{
		return n;
	}
	public static void main(String[] args) throws IOException {
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- >0)
		{
			// HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
			// ArrayList<Integer> al=new ArrayList<Integer>();
			int A[]=new int[3];
			 A[0]=sc.nextInt();
			 A[1]=sc.nextInt();
			int n=sc.nextInt();
			 A[2]=A[0]^A[1];
			System.out.println(A[n%3]);
		}
	}
}
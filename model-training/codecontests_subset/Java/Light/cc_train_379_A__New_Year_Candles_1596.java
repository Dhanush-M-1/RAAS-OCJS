import java.util.*;
import java.io.*;

public class Practice{
	
	public static int numOfSocks(int N, int M){
		int count = N;
		while(N >= M){
			int e = N/M;
			int f = N%M;
			N = e+f;
			count+=e;
			
		}
		return count;
	}
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp[] = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);
        int result = numOfSocks(N, M);
        System.out.println(result);       
    }
}
//package c;
import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader in;
	StringTokenizer str = null;
	
	private String next() throws Exception{
		if (str == null || !str.hasMoreElements())
			str = new StringTokenizer(in.readLine());
		return str.nextToken();
	}
	
	private long nextLong() throws Exception{
		return Long.parseLong(next());
	}
	
	HashMap<Long, Boolean> map;
	public void run() throws Exception{
		in = new BufferedReader(new InputStreamReader(System.in)); 
		map = new HashMap<Long, Boolean>();
		long n = nextLong();
		if (isPrime(n)){
			System.out.println(1);
			System.out.println(0);
			return;
		}
		boolean k = doIt(n);
		if (k){
			System.out.println(1);
			for(long i=2;i*i<=n;i++){
				if (n%i==0){
					k = map.get(new Long(i));
					if (!k){
						System.out.println(i);
						return;
					}
					k = map.get(new Long(n/i));
					if (!k){
						System.out.println(n/i);
						return;
					}
				}
			}
		}else{
			System.out.println(2);
		}
	}
	
	private boolean isPrime(long n){
		for(long i=2;i*i<=n;i++)
			if (n%i == 0) return false;
		return true;
	}
	
	private boolean doIt(long n){
		if (map.containsKey(new Long(n))) {
			return map.get(new Long(n));
		}
		if (isPrime(n)){
			map.put(n, true);
			return true;
		}
		for(long i=2;i*i<=n;i++){
			if (n%i==0){
				boolean k = doIt(i);
				if (!k){
					map.put(n, true);
					return true;
				}
				k = doIt(n/i);
				if (!k){
					map.put(n, true);
					return true;
				}
			}
		}
		map.put(n, false);
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		new Main().run();
	}
}

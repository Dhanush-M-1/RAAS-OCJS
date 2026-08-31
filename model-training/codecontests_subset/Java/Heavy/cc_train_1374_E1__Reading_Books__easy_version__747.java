import java.io.*;
import java.util.*;

public class Main{
	static int N = 200010;
	static long[] one = new long[N];
	static long[] two = new long[N];
	static long[] three = new long[N];
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String[] arr = in.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        
        int ix1 = 0; int ix2 = 0; int ix3 = 0;
        while(n -- > 0) {
        	String[] cur = in.readLine().split(" ");
        	int t = Integer.parseInt(cur[0]);
        	int a = Integer.parseInt(cur[1]);
        	int b = Integer.parseInt(cur[2]);
        	
        	if(a == 1 && b == 1) one[ix1 ++] = t;
        	else if(a == 1 && b == 0) two[ix2 ++] = t;
        	else if(a == 0 && b == 1) three[ix3 ++] = t;
        }
       
        Arrays.sort(one, 0, ix1);
        Arrays.sort(two, 0, ix2);
        Arrays.sort(three, 0, ix3);
        
        if(ix1 + Math.min(ix2, ix3) < k) System.out.println(-1);
        else if(ix1 == 0) {
        	long s = 0;
        	for(int i=0; i<k; i++) s += two[i] + three[i];
        	System.out.println(s);
        }else {
        	PriorityQueue<Long> q = new PriorityQueue<Long>();
        	for(int i=0; i<ix1; i++) q.add(one[i]);
        	for(int i=0; i<Math.min(ix2, ix3); i++) q.add(two[i] + three[i]);
        	
        	long s = 0;
        	for(int i=0; i<k; i++) s += q.poll();
        	System.out.println(s);
        }
    }
}
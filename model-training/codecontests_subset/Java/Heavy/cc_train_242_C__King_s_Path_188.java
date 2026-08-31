import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] A = br.readLine().split(" ");
		int x0 = Integer.parseInt(A[0]);
		int y0 = Integer.parseInt(A[1]);
		int x1 = Integer.parseInt(A[2]);
		int y1 = Integer.parseInt(A[3]);	
		int n = Integer.parseInt(br.readLine());
		int[] allowed = new int[3];
		HashMap<Long, Long> hmap = new HashMap<Long, Long>();
		for(int i=0; i<n; i++) {
		    String[] B = br.readLine().split(" ");
		    allowed[0] = Integer.parseInt(B[0]);
		    allowed[1] = Integer.parseInt(B[1]);
		    allowed[2] = Integer.parseInt(B[2]);
		    for (int j=allowed[1]; j<=allowed[2]; j++)
		        hmap.put((long)allowed[0]*1000000000+j, (long)Long.MAX_VALUE);
		}
		LinkedList<Integer> rowqueue = new LinkedList<Integer>();
		LinkedList<Integer> colqueue = new LinkedList<Integer>();
		rowqueue.add(x0);
		colqueue.add(y0);
		hmap.put( (long)x0*1000000000 + y0, (long)0);
		while(!rowqueue.isEmpty()) {
		    int x = rowqueue.poll();
		    int y = colqueue.poll();
		    int[][] newpos = new int[2][8];
		    newpos[0][0] = x-1;
		    newpos[1][0] = y-1;
		    newpos[0][1] = x;
		    newpos[1][1] = y-1;
		    newpos[0][2] = x+1;
		    newpos[1][2] = y-1;		    
		    newpos[0][3] = x-1;
		    newpos[1][3] = y;		    		    
		    newpos[0][4] = x+1;
		    newpos[1][4] = y;
		    newpos[0][5] = x-1;
		    newpos[1][5] = y+1;		    		    		    
		    newpos[0][6] = x;
		    newpos[1][6] = y+1;		    		    		    		    
		    newpos[0][7] = x+1;
		    newpos[1][7] = y+1;		    	
		    for(int pos=0; pos<8; pos++) {
		        long key = (long)newpos[0][pos]*1000000000 + newpos[1][pos];
		        if (newpos[0][pos]>0 && newpos[0][pos]<1000000000 && newpos[1][pos]>0 && newpos[1][pos]<1000000000 && hmap.containsKey(key)) {
		            long val = hmap.get(key);
		            long currval = hmap.get((long)x*1000000000+y);
		            if(val>currval+(long)1) {
		                hmap.put(key, currval+(long)1);
		                rowqueue.add(newpos[0][pos]);
		                colqueue.add(newpos[1][pos]);
		            }
		        }
		    }
		}
		long myval=Long.MAX_VALUE;
		if(hmap.containsKey((long)1000000000*x1 + y1))
		    myval = hmap.get( (long)1000000000*x1 + y1 );
		System.out.println(myval==Long.MAX_VALUE?-1:myval);
	}
}
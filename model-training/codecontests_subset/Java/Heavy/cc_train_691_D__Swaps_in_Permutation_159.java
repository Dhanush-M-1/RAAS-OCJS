import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int m = fr.nextInt();
		int[] ia = new int[n];
		for(int i = 0; i < n; i++){
			ia[i] = fr.nextInt();
		}
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for(int i = 0; i < n; i++){
            g.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int u = fr.nextInt()-1;
            int v = fr.nextInt()-1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int[] ib = new int[n];
        ArrayList<ArrayList<Integer>> h = new ArrayList<>();
        boolean[] v = new boolean[n];
        for(int i = 0; i < n; i++){
            if(v[i]) continue;
            ArrayList<Integer> al = new ArrayList<>();
            LinkedList<Integer> ll = new LinkedList<>();
            ll.add(i);
            v[i] = true;
            while(!ll.isEmpty()){
                int uu = ll.poll();
                ib[uu] = h.size();
                al.add(uu);
                for(int vv : g.get(uu)){
                    if(v[vv]) continue;
                    ll.add(vv);
                    v[vv] = true;
                }
            }
            h.add(al);
        }
        ArrayList<PriorityQueue<Integer>> apq = new ArrayList<>();
        for(int i = 0; i < h.size(); i++){
            apq.add(new PriorityQueue<>(Collections.reverseOrder()));
        }
        for(int i = 0; i < n; i++){
            apq.get(ib[i]).add(ia[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(apq.get(ib[i]).poll() + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
	}
}

class FastReader{
	BufferedReader br;
	StringTokenizer st;

	FastReader(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next(){
		while(st==null || !st.hasMoreTokens()){
			try{
				st = new StringTokenizer(br.readLine());
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt(){
		return Integer.parseInt(next());
	}

	long nextLong(){
		return Long.parseLong(next());
	}

	double nextDouble(){
		return Double.parseDouble(next());
	}

	String nextLine(){
		String str = "";
		try{
			str = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return str;
	}
}

//source: http://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
  	 	 		 	 		 					  		 			  	
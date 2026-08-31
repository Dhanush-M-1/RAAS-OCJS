import java.io.*;
import java.util.*;





public class codeforces {
	static FastReader fr;
	static class FastReader {

        BufferedReader br;
        StringTokenizer st;
        BufferedWriter bw;
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
            bw=new BufferedWriter(new OutputStreamWriter(System.out));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        char nextChar() {
        	return next().charAt(0);
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        
        void write(String str){
        
                try {
                    bw.write(str);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
        }
        
        void close(){
            try {
                 bw.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
	  fr=new FastReader();
	  int t=1;
	  while(t-->0){
	      solve();
	  }
	  fr.close();
	}

  public static void solve() {
	 int n=fr.nextInt();
	 int[] arr=readArray(n);
	 int sum=0,max=arr[0];
	 for(int i=0;i<n;i++) {
		 max=Math.max(arr[i],max);
		 sum+=arr[i];
	 }
	 int j=max;
	 while(true) {
		 int a=j*n-(sum);
		 if(a>sum) {
			 fr.write(j+"\n");
			 break;
		 }
		 j++;
	 }
  }
  
  public static int[] readArray(int n) {
	  int[] arr=new int[n];
	  for(int i=0;i<n;i++) {
		  arr[i]=fr.nextInt();
	  }
	  return arr;
  }
}

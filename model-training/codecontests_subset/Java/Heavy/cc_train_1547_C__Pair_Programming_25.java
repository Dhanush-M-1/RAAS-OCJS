import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // Start writing your solution here. -------------------------------------
        //   try {
        int t=sc.nextInt();
        while(t-->0){
            int k = sc.nextInt();
            int n = sc.nextInt(),m= sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2=new int[m];
            boolean f=false;
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }
            ArrayList<Integer> arr=new ArrayList<>();
            int i=0,j=0;
            while(i<n || j<m){
                if(i<n && arr1[i]==0){
                    k++;
                    arr.add(0);i++;
                }
                else if(j<m && arr2[j]==0){
                    k++;
                    arr.add(0);j++;
                }
                else if(i<n && arr1[i]<=k){
                    arr.add(arr1[i]);
                    i++;
                }
                else if(j<m && arr2[j]<=k){
                    arr.add(arr2[j]);
                    j++;
                }
                else if(i<n  && arr1[i]>k ){
                    f=true;break;
                }
                else if( j<m &&  arr2[j]>k){
                    f=true;break;
                }
            }
            /*while(i<n){
                if(arr1[i]==0) {
                    arr.add(0);
                    i++;
                }
                if(i<n && arr1[i]<=k){
                    arr.add(arr1[i]);
                    i++;
                }
                if(i<n && arr1[i]>k){
                    f=true;break;
                }
            }
            while(j<m){
                if(arr2[j]==0) {
                    arr.add(0);
                    j++;
                }
                if(j<m && arr2[j]<=k){
                    arr.add(arr2[j]);
                    j++;
                }
                if(j<m && arr2[j]>k){
                    f=true;break;
                }
            }*/
            if(f) out.print(-1);
            else{
                for(int x : arr) out.print(x+" ");
            }
            out.println();
        }
            //   }catch(Exception e){}
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */

        // Stop writing your solution here. -------------------------------------
        out.close();
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //--------------------------------------------------------
}

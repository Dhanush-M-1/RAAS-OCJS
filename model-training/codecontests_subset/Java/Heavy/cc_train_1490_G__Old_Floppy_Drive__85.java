
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OldFloppyDrive {

    public static class Number implements Comparable<Number>{
        long acc;
        long index;
        public Number(long acc, long index){
            this.index = index;
            this.acc = acc;
        }

        @Override
        public int compareTo(Number o) {
            return Long.compare(this.acc,o.acc);
        }
    }

    public static long binarySearch(ArrayList<Number> arr,long atLeast){
        int l = 0;
        int r = arr.size()-1;
        while(r-l>1){
            int mid = l+(r-l)/2;
            if(arr.get(mid).acc < atLeast){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        if(arr.get(l).acc>=atLeast){
            return arr.get(l).index;
        }else if(arr.get(r).acc>=atLeast){
            return arr.get(r).index;
        }else{
            return -1;
        }
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] arr = new long[n];
            long[] queries = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }
            for(int i=0;i<m;i++){
                queries[i] = sc.nextLong();
            }

            HashMap<Long,Long> mp = new HashMap<>();
            long acc = arr[0];
            ArrayList<Number> search = new ArrayList<>();
            search.add(new Number(0l,-1));
            search.add(new Number(acc,0));
            long acc1 = arr[0];
            for(long i=1;i<n;i++){
                acc += arr[(int)i];
                if(acc<=search.get(search.size()-1).acc){
                    continue;
                }
                search.add(new Number(acc,(int)i));
            }
            Collections.sort(search);
            ArrayList<Long> res = new ArrayList<>();
            for(int i=0;i<m;i++){
                if(acc == 0 || (acc < 0 && queries[i] >= 0) || (acc > 0 && queries[i] <= 0)){
                    res.add(binarySearch(search,queries[i]));
                }else{
                    long cnt = 0;
                    long tt = binarySearch(search,queries[i]);
                    if(search.get(search.size()-1).acc >= queries[i] || acc == 0){
                        res.add(tt);
                        continue;
                    }
                    long x = (queries[i] - search.get(search.size()-1).acc)/acc;
                    while(x*acc < (queries[i] - search.get(search.size()-1).acc)){
                        x++;
                    }
                    tt = binarySearch(search,queries[i] - x*acc);
                    res.add(x*n + tt);
                }
            }
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
    }











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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}

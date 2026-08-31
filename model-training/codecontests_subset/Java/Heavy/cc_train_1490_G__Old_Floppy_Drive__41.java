import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner r=new Scanner(System.in);
        int t=r.nextInt();
        while(t-->0){
//            System.out.println("#testcase : ");
            int n=r.nextInt();
            int q=r.nextInt();
            long []a=new long[n];
            long []prefMax=new long[n];
            long Sum=0;
            long maxx=0;
            for(int i=0;i<n;++i){
                a[i]=r.nextLong();
                Sum+=a[i];
                maxx=Math.max(maxx,Sum);
                prefMax[i]=maxx;
            }
            for(int i=0;i<q;++i){
                long x=r.nextInt();
                if(Sum<=0){
                    if(x>maxx){
                        System.out.print(-1+" ");
                    }
                    else{
                        System.out.print(binSearch(x,prefMax,n)+" ");
                    }
                }
                else{
                    long tmp=Math.max(0l,((x-maxx)+Sum-1)/Sum);
                    System.out.print((n*tmp+binSearch(x-Sum*tmp,prefMax,n))+" ");
                }
            }
            System.out.println();
        }
    }

    private static int binSearch(long x, long[] prefMax,int n) {
        int low=0,high=n-1;
        while(low<high){
            int mid=(low+high)>>1;
            if(prefMax[mid]>=x) high=mid;
            else low=mid+1;
        }
        return high;
    }
}
class Scanner{
    public BufferedReader reader;
    public StringTokenizer st;

    public Scanner(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
        st = null;
    }

    public String next(){
        while(st == null || !st.hasMoreTokens()){
            try{
                String line  = reader.readLine();
                if(line == null) return null;
                st =  new StringTokenizer(line);
            }catch (Exception e){
                throw (new RuntimeException());
            }
        }
        return st.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }
    public long nextLong(){
        return Long.parseLong(next());
    }
    public double nextDouble(){
        return Double.parseDouble(next());
    }
}
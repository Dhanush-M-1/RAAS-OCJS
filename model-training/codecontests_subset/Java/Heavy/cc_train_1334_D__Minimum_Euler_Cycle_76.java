import java.io.*;
import java.util.*;
public class ER85D {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer tok=new StringTokenizer(in.readLine());
            long N=Long.parseLong(tok.nextToken()),
                    L=Long.parseLong(tok.nextToken())-1,
                    R=Long.parseLong(tok.nextToken())-1;
            long nc2=N*(N-1)/2;
            //0,1,0,2,0,3,...,0,N-1
            //1,2,1,3,1,4,....1,N-1
            //2,3,2,4,2,5,...,2,N-1
            //3,4,3,5,...
            //...
            //N-2,N-1
            //0
            //--> (0,1),(0,2),(0,3),...,(0,N-1)
            //      (1,2),(1,3),...,(1,N-1)
            //      (2,3),...
            //      ...
            //      (N-2,N-1)
            //      0
            //(0,i+1) for i in [0,N-1)
            //(1,i+2) for i in [0,N-2)
            long A=L/2, B=R/2;
            //if (A<nc2) {
            List<long[]> pairs=new ArrayList<>();
            if (A<nc2)
                pairs.add(pair(N,A));
            for (long i=A+1; i<=B && i<nc2; i++) {
                long[] prev=pairs.get(pairs.size()-1);
                long[] cur=prev.clone();
                cur[1]++;
                if (cur[1]==N) {
                    cur[0]++;
                    cur[1]=cur[0]+1;
                }
                pairs.add(cur);
            }
            /*System.out.println(N+" "+L+" "+R+" "+A+" "+B);
            for (long[] a:pairs)
                System.out.println(Arrays.toString(a));*/
            //pairs.get(j) represents idxs 2*(A+j),2*(A+j)+1
            for (long i=L; i<=R; i++) {
                if (i/2<nc2) {
                    long pi = i / 2 - A;//(i-L)/2;
                    //2*(A+j) or 2*(A+j)+1==i
                    //A+j==i/2
                    //System.out.println("pi="+pi);
                    out.append(pairs.get((int) pi)[(int) (i % 2)]+1);
                }
                else
                    out.append(1);
                out.append(i<R?" ":"\n");
            }
                //if (B<nc2) {
                    //long[] lp = pair(N, A);//, rp = pair(N, B);


                //}
            //}
        }
        System.out.print(out);
        /*int N=50;
        for (int i=0; i<N*(N-1)/2; i++)
            System.out.println(Arrays.toString(pair(N,i)));*/
    }
    private static long[] pair(long N, long idx) {
        long a=0;
        long cnt=0;
        while (cnt+N-1-a<=idx) {
            cnt+=N-1-a;
            a++;
        }
        return new long[] {a,a+1+idx-cnt};
    }
}
import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class Vd
{

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer token;
    
    static final int nm=100002;
    
    static int n,m;
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<ArrayList<Integer>> cs;
    static int kq[][];
    static int nkq;
    static boolean blocked[];
    
    static int partition(int i)
    {
        int j,k,tg;ArrayList<Integer> np,p;
        np=new ArrayList<Integer>();
        p=new ArrayList<Integer>();
        for(k=0;k<adj.get(i).size();++k)
        {
            if (!blocked[cs.get(i).get(k)])
            {
                blocked[cs.get(i).get(k)]=true;
                j=adj.get(i).get(k);
                p.add(j);
            }
        }
        for(k=0;k<p.size();++k)
        {
            j=p.get(k);
            tg=partition(j);
            if (tg==-1) np.add(j);
            else
            {
                kq[nkq][0]=i+1;kq[nkq][1]=j+1;kq[nkq][2]=tg+1;
                nkq++;
            }
        }
        while (np.size()>=2)
        {
            j=np.get(np.size()-1);k=np.get(np.size()-2);
            kq[nkq][0]=j+1;kq[nkq][1]=i+1;kq[nkq][2]=k+1;
            nkq++;
            np.remove(np.size()-1);np.remove(np.size()-1);
        }
        if (np.size()>0) return np.get(np.size()-1);
        else return -1;
    }
    
    public static void main(String args[]) throws IOException
    {
        in=new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(new OutputStreamWriter(System.out));
        int i,u,v;
        token=new StringTokenizer(in.readLine());
        n=Integer.parseInt(token.nextToken());m=Integer.parseInt(token.nextToken());
        if (m%2!=0)
        {
            out.print("No solution");
            in.close();out.close();return;
        }
        adj=new ArrayList<ArrayList<Integer>>();
        for(i=0;i<n;++i) adj.add(new ArrayList<Integer>());
        cs=new ArrayList<ArrayList<Integer>>();
        for(i=0;i<n;++i) cs.add(new ArrayList<Integer>());
        kq=new int[m/2][3];nkq=0;
        blocked=new boolean[m];
        Arrays.fill(blocked,false);
        for(i=0;i<m;++i)
        {
            token=new StringTokenizer(in.readLine());
            u=Integer.parseInt(token.nextToken());v=Integer.parseInt(token.nextToken());
            adj.get(u-1).add(v-1);adj.get(v-1).add(u-1);
            cs.get(u-1).add(i);cs.get(v-1).add(i);
        }
        if (partition(0)!=-1) out.print("No solution");
        else
        {
            for(i=0;i<nkq;++i) out.println(kq[i][0]+" "+kq[i][1]+" "+kq[i][2]);
        }
        in.close();out.close();
    }
    
    
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
public class D1107 
{
    static class Scanner
    {
        BufferedReader br;
        StringTokenizer tk=new StringTokenizer("");
        public Scanner(InputStream is) 
        {
            br=new BufferedReader(new InputStreamReader(is));
        }
        public int nextInt() throws IOException
        {
            if(tk.hasMoreTokens())
                return Integer.parseInt(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return nextInt();
        }
        public long nextLong() throws IOException
        {
            if(tk.hasMoreTokens())
                return Long.parseLong(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return nextLong();
        }
        public String next() throws IOException
        {
            if(tk.hasMoreTokens())
                return (tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return next();
        }
        public String nextLine() throws IOException
        {
            tk=new StringTokenizer("");
            return br.readLine();
        }
        public double nextDouble() throws IOException
        {
            if(tk.hasMoreTokens())
                return Double.parseDouble(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return nextDouble();
        }
        public char nextChar() throws IOException
        {
            if(tk.hasMoreTokens())
                return (tk.nextToken().charAt(0));
            tk=new StringTokenizer(br.readLine());
            return nextChar();
        }
        public int[] nextIntArray(int n) throws IOException
        {
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=nextInt();
            return a;
        }
        public long[] nextLongArray(int n) throws IOException
        {
            long a[]=new long[n];
            for(int i=0;i<n;i++)
                a[i]=nextLong();
            return a;
        }
        public int[] nextIntArrayOneBased(int n) throws IOException
        {
            int a[]=new int[n+1];
            for(int i=1;i<=n;i++)
                a[i]=nextInt();
            return a;
        }
        public long[] nextLongArrayOneBased(int n) throws IOException
        {
            long a[]=new long[n+1];
            for(int i=1;i<=n;i++)
                a[i]=nextLong();
            return a;
        }
    
    
    }
    static int mat[][];
    static boolean comp(int v){
        int n=mat.length;
        int a[][]=new int[n/v][n/v];
        int nv=n/v;
        for(int i=0;i<nv;i++)
            for(int j=0;j<nv;j++)
                a[i][j]=-1;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(a[i/v][j/v]==-1)
                    a[i/v][j/v]=mat[i][j];
                else if(a[i/v][j/v]!=mat[i][j])
                    return false;
            }
        mat=a;
        return true;
    }
    public static void main(String args[]) throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int C[]=new int[256];
        for(int i=0;i<=9;i++)
            C['0'+i]=i;
        C['A']=10;
        C['B']=11;
        C['C']=12;
        C['D']=13;
        C['E']=14;
        C['F']=15;
        int p2[]=new int[5];
        p2[3]=1;
        p2[2]=2;
        p2[1]=4;
        p2[0]=8;
               
        int n=in.nextInt();
        int ans=1;
        mat=new int[n][n];
        for(int i=0;i<n;i++){
            String s=in.next();
            for(int j=0;j<n;j+=4){
                int v=C[s.charAt(j/4)];
                for(int k=0;k<4;k++)
                    if((v&p2[k])>0)
                        mat[i][k+j]=1;
                
            }
        }
        int cn=n;
        for(int i=2;i<=n;i++){
            if(n%i==0){
                
                while((n%i==0)&&comp(i)){
                    ans*=i;
                    n/=i;
                }
                while(n%i==0)
                    n/=i;
                        
            }
        }
        out.println(ans);
        out.close();
    }

}
import java.io.*;
import java.util.*;
public class Main implements Runnable{
    
    private void solve()throws IOException{
        String N=nextLine();
        int k=nextInt();
        int n=N.length();
        int first=N.charAt(0)-'0';
        long ans=0;
        int i;
        switch(k){
            case 1:
            ans=1l*9*(n-1)+first;
            break;
            case 2:
            ans=1l*9*9*(n-1)*(n-2)/2;
            ans+=1l*(N.charAt(0)-'0'-1)*(n-1)*9;
            i=2;
            while(i<=n && N.charAt(i-1)=='0')
                i++;
            if(i==n+1)
                break;
            ans+=1l*(n-i)*9+(N.charAt(i-1)-'0');
            break;
            case 3:
            ans=1l*9*9*9*(n-1)*(n-2)*(n-3)/6;
            ans+=1l*(N.charAt(0)-'0'-1)*9*9*(n-1)*(n-2)/2;  
            i=2;
            while(i<=n && N.charAt(i-1)=='0')
                i++;
            if(i==n+1)
                break;
            ans+=1l*9*9*(n-i)*(n-i-1)/2;
            ans+=1l*(N.charAt(i-1)-'0'-1)*(n-i)*9;
            i++;
            while(i<=n && N.charAt(i-1)=='0')
                i++;
            if(i==n+1)
                break;
            ans+=1l*9*(n-i)+(N.charAt(i-1)-'0');
            break;
        }
        out.println(ans);
    }

     
    ///////////////////////////////////////////////////////////

    final long mod=(long)(1e9+7);
    final int inf=(int)(1e9+1);
    final int maxn=(int)(1e6);
    final long lim=(long)(1e18);

    public void run(){
        try{
            br=new BufferedReader(new InputStreamReader(System.in));
            st=null;
            out=new PrintWriter(System.out);

            solve();

            // int t=nextInt();
            // for(int i=1;i<=t;i++){
            //     // out.print("Case #"+i+": ");
            //     solve();
            // }

            br.close();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static void main(String args[])throws IOException{
        new Main().run();
    } 
    int max(int ... a){
        int ret=a[0];
        for(int i=1;i<a.length;i++)
        ret=Math.max(ret,a[i]);
        return ret;
    }
    int min(int ... a){
        int ret=a[0];
        for(int i=1;i<a.length;i++)
        ret=Math.min(ret,a[i]);
        return ret;
    }
    void debug(Object ... a){
        System.out.print("> ");
        for(int i=0;i<a.length;i++)
        System.out.print(a[i]+" ");
        System.out.println();
    }
    void debug(int a[]){debuga(Arrays.stream(a).boxed().toArray());}
    void debug(long a[]){debuga(Arrays.stream(a).boxed().toArray());}
    void debuga(Object a[]){
        System.out.print("> ");
        for(int i=0;i<a.length;i++)
        System.out.print(a[i]+" ");
        System.out.println();
    }
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;
    String nextToken()throws IOException{
        while(st==null || !st.hasMoreTokens())
        st=new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    String nextLine()throws IOException{
        return br.readLine();
    }
    int nextInt()throws IOException{
        return Integer.parseInt(nextToken());
    }
    long nextLong()throws IOException{
        return Long.parseLong(nextToken());
    }
    double nextDouble()throws IOException{
        return Double.parseDouble(nextToken());
    }
}
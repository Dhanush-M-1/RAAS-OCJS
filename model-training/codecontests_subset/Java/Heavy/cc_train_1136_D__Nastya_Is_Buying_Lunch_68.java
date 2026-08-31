    import java.io.*;
    import java.util.*;
    import java.math.*;
     
    public class bhaa {
     
        InputStream is;
        PrintWriter o;
        /////////////////// CODED++ BY++ ++ ++ ++ BHAVYA++ ARORA++ ++ ++ ++ FROM++ JAYPEE++ INSTITUTE++ OF++ INFORMATION++ TECHNOLOGY++ ////////////////
     
    ///////////////////////// Make it work, make it right, make it fast. Make it work, make it right, make it fast. Make it work, make it right, make it fast. Make it work, make it right, make it fast. /////////////////
     
    
        
        void solve() {
            int n=ni();
            int m=ni();

            ArrayList<Integer>ad[]=new ArrayList[n+1];
            //for(int i=0;i<)
            ArrayList<Integer>al=new ArrayList<Integer>();

            //int arr[]=nia(n);
            for(int i=0;i<n;i++)
            {
                al.add(ni());
            }
            int aage=n-1;
            int nhijaega=0;
            for(int i=0;i<=n;i++)
            {
                ad[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<m;i++)
            {
                ad[ni()].add(ni());
            }
            for(int i=0;i<=n;i++)
            {
                Collections.sort(ad[i]);
            }
           //boolean chk[]=new boolean[n];
            for(int i=n-2;i>=0;i--)
            {
                int f=1;
                int ele=al.get(i);
                for(int j=i+1;j<al.size();j++)
                {

                    if(Collections.binarySearch(ad[ele],al.get(j))<0)
                    {
                        f=0;
                        nhijaega++;
                        break;
                    }






                }
                if(f==1)
                {
                    al.remove(i);

                }
            }
            o.println(aage-nhijaega);

           
     
        
     
            
            
     
            
     
     
        }
     
     
     
     
     
     
       
     
     
        
     
     
     
     
     
     
     
     
     
     
     
     
        
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
        //---------- I/O Template ----------
        
        public static void main(String[] args) { new bhaa().run(); }
        void run() { 
            is = System.in; 
            o = new PrintWriter(System.out);
            solve();
            o.flush();
        }
        
        byte input[] = new byte[1024];
        int len = 0, ptr = 0;
        
        int readByte() { 
            if(ptr >= len) { ptr = 0; 
                try { len = is.read(input); } 
                catch(IOException e) { throw new InputMismatchException(); } 
                if(len <= 0) { return -1; } 
            } return input[ptr++];
        }
        boolean isSpaceChar(int c) { return !( c >= 33 && c <= 126 ); }
        int skip() { 
            int b = readByte(); 
            while(b != -1 && isSpaceChar(b)) { b = readByte(); } 
            return b;
        }
        
        char nc() { return (char)skip(); }
        String ns() { 
            int b = skip(); 
            StringBuilder sb = new StringBuilder(); 
            while(!isSpaceChar(b)) { sb.appendCodePoint(b); b = readByte(); } 
            return sb.toString();
        }
        String nLine() { 
            int b = skip(); 
            StringBuilder sb = new StringBuilder(); 
            while( !(isSpaceChar(b) && b != ' ') ) { sb.appendCodePoint(b); b = readByte(); } 
            return sb.toString();
        }
        int ni() { 
            int n = 0, b = readByte(); 
            boolean minus = false; 
            while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
            if(b == '-') { minus = true; b = readByte(); } 
            if(b == -1) { return -1; }  //no input 
            while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
            return minus ? -n : n;
        }
        long nl() { 
            long n = 0L;    int b = readByte(); 
            boolean minus = false; 
            while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
            if(b == '-') { minus = true; b = readByte(); } 
            while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
            return minus ? -n : n;
        }
     
        double nd() { return Double.parseDouble(ns()); }
        float nf() { return Float.parseFloat(ns()); }
        int[] nia(int n) { 
            int a[] = new int[n]; 
            for(int i = 0; i < n; i++) { a[i] = ni(); } 
            return a;
        }
        long[] nla(int n) { 
            long a[] = new long[n]; 
            for(int i = 0; i < n; i++) { a[i] = nl(); } 
            return a;
        }
        int [][] nim(int n)
        {
            int mat[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j]=ni();
                }
            }
            return mat;
        }
        long [][] nlm(int n)
        {
            long mat[][]=new long[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j]=nl();
                }
            }
            return mat;
        }
        
     
     
     
     
        
        char[] ns(int n) { 
            char c[] = new char[n]; 
            int i, b = skip(); 
            for(i = 0; i < n; i++) { 
                if(isSpaceChar(b)) { break; } 
                c[i] = (char)b; b = readByte(); 
            } return i == n ? c : Arrays.copyOf(c,i);
        }
        void piarr(int arr[])
        {
            for(int i=0;i<arr.length;i++)
            {
                o.print(arr[i]+" ");
     
            }
            o.println();
        }
        void plarr(long arr[])
        {
            for(int i=0;i<arr.length;i++)
            {
                o.print(arr[i]+" ");
     
            }
            o.println();
        }
        
        void pimat(int mat[][])
        {
            for(int i=0;i<mat.length;i++)
            {
                for(int j=0;j<mat[0].length;j++)
                {
                    o.print(mat[i][j]+" ");
                }
                o.println();
            }
        }
        void plmat(long mat[][])
        {
            for(int i=0;i<mat.length;i++)
            {
                for(int j=0;j<mat[0].length;j++)
                {
                    o.print(mat[i][j]+" ");
                }
                o.println();
            }
     
        }
       static class DJset
{
    int n;
    ty1 arr[];
    class ty1
    {
        int rank;
        int par;
        ty1(int p,int r)
        {
            par=p;
            rank=r;
        }
    }
    DJset(int nu)
    {
        n=nu;
        arr=new ty1[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=new ty1(i,1);
        }

    }
    int find(int x)
    {
        if(arr[x].par!=x)
        {
            arr[x].par=find(arr[x].par);
        }
        return arr[x].par;
    }
    void union(int x,int y)
    {
        x=find(x);
        y=find(y);
        if(x!=y)
        {
            if(arr[x].rank<arr[y].rank)
            {
                arr[x].par=y;
            }
            else if(arr[y].rank<arr[x].rank)
            {
                arr[y].par=x;
            }
            else
            {
                arr[x].rank++;
                arr[y].par=x;

            }
        }
    }
    public String toString()
    {
        String res="";
        for(int i=0;i<n;i++)
        {
            res+=(arr[i].par+" ");
        }
        
        return res;
    }
    public int countsets()
    {
        int res=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i].par==i)
            {
                res++;
            }
        }
        return res;
    }

    

    }
    
     
     
     
     
        //////////////////////////////////// template finished //////////////////////////////////////
     
     
     
    }


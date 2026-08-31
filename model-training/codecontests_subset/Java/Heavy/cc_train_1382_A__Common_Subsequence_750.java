import java.util.*;
import java.io.*;
public class vivek{    
    static class FastReader 
    { 
 
        BufferedReader br; 
        StringTokenizer st; 
 
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
 
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
 
        char nextChar()
        {
            return next().charAt(0);
        }
 
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
 
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
 
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
 
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
 
        int[] nextArray(int rows)
        {
            int arr[] = new int[rows];            
            for (int i = 0; i < rows; i++)
            arr[i] = nextInt();
            return arr;
        }
 
        long[] nextLongArray(int rows)
        {
            long arr[] = new long[rows];            
            for (int i = 0; i < rows; i++)
            arr[i] = nextLong();
            return arr;
        }
 
        char[] nextCharArray(int rows)
        {
            char arr[] = new char[rows];
            for (int i = 0; i < rows; i++)
            arr[i] = next().charAt(0);
            return arr;
        }
 
        int[][] nextMatrix(int rows, int columns)
        {
            int mat[][] = new int[rows][columns];
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    mat[i][j] = nextInt();
                }
            }
            return mat;
        }
    } 
    public static void main(String args[]){
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
            int f=0;
            int x=0;
            LinkedList <Integer> v=new LinkedList ();
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++){
                b[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(a[i]==b[j]){
                        v.add(a[i]);
                        f++;
                        break;
                    }
                }
                if(f==1){
                    x=a[i];
                    break;
                }
            }
            if(f>0){
                System.out.println("YES");
                System.out.print(v.size()+" ");
                Iterator <Integer> i= v.listIterator();
                while (i.hasNext()) 
                { 
                    System.out.print(i.next()+" ");
                } 
                System.out.println();
            }
            else
                System.out.println("NO");
        }
    }
}
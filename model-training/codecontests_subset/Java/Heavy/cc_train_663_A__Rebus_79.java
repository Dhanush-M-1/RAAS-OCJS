
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Rebus {
    public static void main (String[]args) throws IOException {

        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st =new StringTokenizer(sc.nextLine());
        int n=st.countTokens()/2;

        char sign[]=new char[n];
        int val[]= new int[n];
        Arrays.fill(val,1);
        sign[0]='+';
       
        int cSum=1;

       
        for(int i=1;i<n;i++){
            st.nextToken();
            sign[i]=st.nextToken().charAt(0);
            cSum+= sign[i]=='+' ?1:-1;
                
        }

        st.nextToken();
        st.nextToken();
        int sum=Integer.parseInt(st.nextToken());
        
        int rem=sum-cSum;
        if(rem>0) {
        	for(int i=0;i<n&&rem>0;i++) {
        		if(sign[i]=='+') {
        			val[i]+=Math.min(sum-1, rem);
        			rem-=Math.min(sum-1, rem);
        		}
        	}
        	
        }
        else {
        	for(int i=0;i<n&&rem<0;i++) {
        		if(sign[i]=='-') {
        			val[i]+=Math.min(sum-1, Math.abs(rem));
        			rem+=Math.min(sum-1, Math.abs(rem));
        		}
        	}
        }
        if(rem==0) {
        	out.println("Possible");
        	for(int i=0;i<n;i++) {
        		out.print(val[i]+" ");
        		if(i<n-1)
        			out.print(sign[i+1]+" ");
        	}
        	out.print("= "+sum);
        }
        else {
        	out.println("Impossible");
        }

        out.flush();
        out.close();


    }
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public boolean ready() throws IOException {return br.ready();}


    }
}

//package acc;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
   public  class ACC { 
//************Main*****************//
      
       
    
         public static void main(String[] args) throws IOException
			 {
             //   PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
              //  Scanner in=new Scanner (System.in);
               InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                int n=in.nextInt();
                long k=in.nextInt();
                int arr[]=new int [n+1];
                for(int i=1;i<=n;i++) arr[i]=in.nextInt();
                k*=2;
                int i=1;
                for( i=1;i<=n+1;i++){
                   if((long)i*i+i>=k) break; 
                }
                i--;
                k/=2;
                long sum=(long)i*(i+1)/2;
                int ind=-1;
                for(int j=1;j<=i+1;j++){
                    sum++;
                    if(sum==k) {
                        ind=j;
                        break;
                    }
                }
                
                out.print(arr[ind]);
                out.close();
         }
         
   }
    class Pair implements Comparable<Pair>{
    int x,y;
    public  Pair(int X,int Y){
        super();
x=X;
y=Y;
}
    @Override
      public int compareTo(Pair p){
          if((x)==(p.x)) return Integer.compare((y), (p.y));
       return Integer.compare((x), (p.x));
}
  }

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong(){
        return Long.parseLong(next());
    }
}
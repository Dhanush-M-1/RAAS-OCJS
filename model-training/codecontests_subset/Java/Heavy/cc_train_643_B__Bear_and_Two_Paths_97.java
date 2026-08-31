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
                int n=in.nextInt(),e=in.nextInt(),a=in.nextInt(),b=in.nextInt(),c=in.nextInt(),d=in.nextInt();
                if(e<n+1||n<5) {
                    out.print(-1);
                    out.close();
                }
                
                else{
                    
                    
                    List<Integer> l=new ArrayList<>();
                    int point1=0,point2=0;
                    
                    l.add(a);
                    for(int i=1;i<=n;i++){
                        if(i==a||i==b||i==c||i==d) continue;
                        if(point1==0){
                            point1=i;
                            continue;
                        }
                        if(point2==0){
                            point2=i;
                            continue;
                        }
                        l.add(i);
                    }
                    if(n==5){
                        out.println(a+" "+c+" "+point1+" "+d+" "+b);
                        
                        out.print(c+" "+a+" "+point1+" "+b+" "+d);
                             
                                
                    }
                    else{
                    l.add(c);
                    for(int i=0;i<l.size();i++){
                        out.print(l.get(i)+" ");
                    }
                    out.println(point2+" "+d+" "+point1+" "+b);
                    for(int i=l.size()-1;i>=0;i--){
                        out.print(l.get(i)+" ");
                    }
                    out.print(point1+" "+b+" "+point2+" "+d);
                }
                }
                        
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
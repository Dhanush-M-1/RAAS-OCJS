import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]){
        //Scanner s= new Scanner(System.in);
         InputReader s= new InputReader(System.in);
         OutputStream outputStream= System.out;
         PrintWriter out= new PrintWriter(outputStream);
         int n=s.nextInt();
         int m=s.nextInt();
         int w[]=new int[n];
         int temp[]=new int[n+1];
         int b[]=new int[n];
         int read[]=new int[m];
         for(int i=0;i<n;i++){
             w[i]=s.nextInt();
         }
         int size=0;
         for(int i=0;i<m;i++){
             int x=s.nextInt();
             read[i]=x;
             if(temp[x]==0){
                 b[size]=x;
                 temp[x]=1;
                 size++;
             }
         }
         /*for(int i=0;i<size;i++){
             out.print(b[i]+" ");
         }*/
         int ans=0;
         for(int i=0;i<m;i++){
             for(int j=0;j<size;j++){
                 if(b[j]==read[i]){
                     int temp1=b[j];
                     for(int k=j-1;k>=0;k--){
                         
                         ans+=w[b[k]-1];
                         b[k+1]=b[k];
                         
                     }
                     b[0]=temp1;
                     break;
                 }
             }
         }
         out.println(ans);
         out.close();
    }
    
    static class InputReader {
        
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader( InputStream inputstream) {
          reader = new BufferedReader(new InputStreamReader(inputstream));
          tokenizer = null;
        }
        
        public String nextLine(){
            String fullLine=null;
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                  fullLine=reader.readLine();
                } catch (IOException e) {
                  throw new RuntimeException(e);
                }
                return fullLine;
              }
              return fullLine;
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
        public long nextLong() {
              return Long.parseLong(next());
            }
        public int nextInt() {
          return Integer.parseInt(next());
        }
      }
}

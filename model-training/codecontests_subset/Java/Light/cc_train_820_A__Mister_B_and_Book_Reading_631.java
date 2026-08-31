import java.util.*;
import java.io.*;
public class Round421q1{
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    int nextInt(){
      return Integer.parseInt(next());
    }
    String next(){
      while(st==null || !st.hasMoreElements()){
        try{
          st = new StringTokenizer(br.readLine());
        }
        catch (IOException e){
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

  }






  public static void main(String[] args) throws IOException{
    FastReader fr = new FastReader();
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int bookPages = fr.nextInt();
    int initialSpeed = fr.nextInt();
    int topSpeed = fr.nextInt();
    int speedInc = fr.nextInt();
    int pageRevise = fr.nextInt();

    int ans =0;
    int pagesRead = 0;
    while(pagesRead<bookPages){
      int presentSpeed = initialSpeed + ans*speedInc;
      presentSpeed = presentSpeed<topSpeed? presentSpeed : topSpeed;
      pagesRead = ans==0? presentSpeed: pagesRead+presentSpeed-pageRevise;
      ans++;
    }
    out.write(Integer.toString(ans)+"\n");
    out.flush();
  }
}

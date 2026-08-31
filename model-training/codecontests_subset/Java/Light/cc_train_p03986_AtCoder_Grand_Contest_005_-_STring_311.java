import java.io.*;

public class Main {
    
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //String[] in1 = br.readLine().split(" ");
    //int N = Integer.parseInt(in1[0]);
    String S = br.readLine();
    
    br.close();

    int N = S.length();
    int stockedS = 0;
    int ans = N;
    for(int i = 0; i < N; i++){
      if(S.charAt(i) == 'S') stockedS++;
      else if(stockedS > 0){
        stockedS--;
        ans -= 2;
      }
    }

    System.out.println(ans);
  }
}
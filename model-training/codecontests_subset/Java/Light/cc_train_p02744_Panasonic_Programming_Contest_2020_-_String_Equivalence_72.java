import java.io.*;


public class Main {

  static int N;

  static void dfs(String S, char ma){
    if(S.length() == N){
      System.out.println(S);
      return;
    }

    for(char c = 'a'; c < ma; c++){
      dfs(S + c, ma);
    }
    dfs(S + ma, ++ma);
    
    return;
  }
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] in = br.readLine().split(" ");
    N = Integer.parseInt(in[0]);

    br.close();

    dfs("", 'a');
    
  }
}

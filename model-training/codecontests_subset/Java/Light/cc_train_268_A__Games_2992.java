import java.io.*;

public class Games {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    int[] home = new int[n];
    int[] guest = new int[n];
    int k = 0;
    for(int i = 0;i<n;i++){
      String[] temp = in.readLine().split(" ");
      int h = Integer.parseInt(temp[0]);
      int g = Integer.parseInt(temp[1]);
      home[i] = h;
      guest[i] = g;
    }
    for(int i = 0;i<n;i++){
      for(int j = 0;j<n;j++){
        if(i != j){
          if(home[i] == guest[j]){
            k++;
          }
        }
      }
    }
    System.out.println(k);
  }
}

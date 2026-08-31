import java.util.*;
import java.io.*;

public class Main{

  BufferedReader in;
  StringTokenizer str = null;

  private String next() throws Exception{
    if(str == null || !str.hasMoreElements())
      str = new StringTokenizer(in.readLine());
    return str.nextToken();
  }

  private int nextInt() throws Exception{
    return Integer.parseInt(next());
  }

  public void run() throws Exception{
    in = new BufferedReader(new InputStreamReader(System.in));
    int k = nextInt();
    char []a = next().toCharArray();
    
    int b[] = new int[30];
    for(int i=0;i<a.length;i++) b[a[i]-'a']++;
    for(int i=0;i<b.length;i++)
      if (b[i] % k != 0){
        System.out.println(-1);
        return;
      }
    for(int i=0;i<k;i++){
      for(int j=0;j<b.length;j++)
        if (b[j] > 0){
          for(int l=0;l<b[j]/k;l++){
            System.out.print((char)(j + 'a'));
          }
        }
    }
    System.out.println();
   
  }

  public static void main(String args[]) throws Exception{
    new Main().run();  
  }
}
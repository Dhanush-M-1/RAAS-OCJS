import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Bulbs {
      public static void main(String args[]) throws IOException{
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          String s[]=br.readLine().split(" ");
          int n=Integer.parseInt(s[0]);
          int m=Integer.parseInt(s[1]);
          int a[]=new int[m+1];
          int counter=0;
          for(int i=0;i<n;i++){
              String s1[]=br.readLine().split(" ");
              for(int j=0;j<Integer.parseInt(s1[0]);j++){
                  a[Integer.parseInt(s1[j+1])]++;
              }
          }
          for(int i=1;i<=m;i++){
              if(a[i]==0){
                  System.out.println("NO");
                  counter++;
                  break;
              }
          }
          if(counter==0){
              System.out.println("YES");
          }
      }
}

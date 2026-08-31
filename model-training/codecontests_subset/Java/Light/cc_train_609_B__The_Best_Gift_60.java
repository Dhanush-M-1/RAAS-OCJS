import java.io.*;
import java.util.*;
public class Books{
 public static void main(String[] args) throws IOException{
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String s[]=br.readLine().split(" ");
  int a=Integer.parseInt(s[0]);
  int b=Integer.parseInt(s[1]);
  int a1[]=new int[a];
  int a2[]=new int[b];
  int k=0,c=0;
  for(int i=0;i<b;i++)
    a2[i]=1;
  String s1[]=br.readLine().split(" ");
  for(int i=0;i<a;i++)
   a1[i]=Integer.parseInt(s1[i]);
  Arrays.sort(a1);
   for(int j=0;j<(a-1);j++){
      if(a1[j+1]==a1[j])
            a2[k]++;
            else
                k++;
            
         }
  k=b;
         for(int g=0;g<k;g++){
            for(int h=(g+1);h<k;h++)
                c+=(a2[g]*a2[h]);}
   System.out.println(c);
}
}
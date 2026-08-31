import java.io.*;
import java.util.*;
public class codeforces {
  public static void main( String[] args) throws Exception {
    Scanner inp = new Scanner(System.in);
      int n=inp.nextInt();
      String s=inp.next();
      String f="";
      int max=0;
      for(int i=0;i<n-1;i++){
        int sum=0;
        for(int j=0;j<n-1;j++){
           if(s.charAt(i)==s.charAt(j) && s.charAt(i+1)==s.charAt(j+1)){
            sum++;
          }
        }
        if(sum>max){
          max=sum;
          f=s.charAt(i)+""+s.charAt(i+1)+"";
        }
      }
      System.out.println(f);
     inp.close();
     return ;
  }
}

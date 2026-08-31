import java.util.*;
import java.io.*;
public class CodeF_Equivalent580D_2{
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    String a = br.readLine();
    String b = br.readLine();
    
    if(eqv(a).equals(eqv(b)))
      pw.println("YES");
    else
      pw.println("NO");
    pw.close();
    
    }
  public static String eqv(String s){
    if(s.length() == 1 || s.length() %2 == 1)
      return s;
    else{
      String a = eqv(s.substring(0,s.length()/2));
      String b = eqv(s.substring(s.length()/2));
      
      if( a.compareTo(b) < 0)
        return a+b;
      else
        return b+a;
    }
  }
}
    
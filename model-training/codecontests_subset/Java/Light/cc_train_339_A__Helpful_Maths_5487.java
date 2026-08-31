
import java.util.*;
public class main {
    public static void main(String[] args) {
      Scanner s = new Scanner (System.in);
     Stack st= new Stack();
      String t=s.next();
      String hh=t;
      String n="";
      t=t.replaceAll("[+]", "");
       char x[]=new char[t.length()];
            for (int i=0;i<t.length();i++){
                x[i]=t.charAt(i);
            }
        Arrays.sort(x);
      
      for (int i=0;i<t.length();i++){
          if ( i==t.length()-1){
       n+=x[i];} else { 
               n+=x[i]; n+="+";
          }
      
        
      }
        
        System.out.println(n);
    }
}

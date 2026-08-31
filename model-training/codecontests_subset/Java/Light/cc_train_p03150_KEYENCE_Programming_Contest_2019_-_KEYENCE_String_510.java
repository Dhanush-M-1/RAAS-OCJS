import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Main{
  
  public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    
    String S = sc.next();
    String ans;
    Pattern p1 = Pattern.compile("^k.*eyence$");
    Pattern p2 = Pattern.compile("^ke.*yence$");
    Pattern p3 = Pattern.compile("^key.*ence$");
    Pattern p4 = Pattern.compile("^keye.*nce$");
    Pattern p5 = Pattern.compile("^keyen.*ce$");
    Pattern p6 = Pattern.compile("^keyenc.*e$");
    Pattern p7 = Pattern.compile(" *.keyence$");
    Pattern p8 = Pattern.compile("^keyence.* ");
    Matcher m1 = p1.matcher(S);
    Matcher m2 = p2.matcher(S);
    Matcher m3 = p3.matcher(S);
    Matcher m4 = p4.matcher(S);
    Matcher m5 = p5.matcher(S);
    Matcher m6 = p6.matcher(S);
    Matcher m7 = p7.matcher(S);
    Matcher m8 = p8.matcher(S);
    
      if(m1.find() == true){
          System.out.println("YES");
          return;
      }else{
          ans = "NO";
      }
         
      if(m2.find() == true){
          System.out.println("YES");
          return;
      }else{
          ans = "NO";
      }
         
      if(m3.find() == true){
          System.out.println("YES");
          return;
      }else{
          ans = "NO";
      }
         
      if(m4.find() == true){
          System.out.println("YES");
          return;
      }else{
         ans = "NO";
      }
         
      if(m5.find() == true){
          System.out.println("YES");
          return;
      }else{
          ans = "NO";
      }
         
      if(m6.find() == true){
          System.out.println("YES");
          return;
      }else{
         ans = "NO";
      }
      
       if(m7.find() == true){
          System.out.println("YES");
          return;
      }else{
         ans = "NO";
      }
      
       if(m8.find() == true){
          System.out.println("YES");
          return;
      }else{
         ans = "NO";
      }
    
      System.out.println(ans);
    
  }  
}
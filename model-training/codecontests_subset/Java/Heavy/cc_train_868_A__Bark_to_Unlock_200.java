import java.util.*;
import java.io.*;

public class MyClass {
    public static void main(String args[]) throws IOException{
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String passwd = br.readLine();
      int n = Integer.parseInt(br.readLine());
      
      boolean unlockedFirst = false;
      boolean unlockedSecond = false;
      
      while(n-- > 0)
      {
          String str = br.readLine();
          
          if(!unlockedFirst)
          {
              if(str.equals(passwd)) {unlockedFirst=unlockedSecond=true;}
              else if(str.charAt(1) == passwd.charAt(0)) unlockedFirst = true;
          }
          if(!unlockedSecond)
          {
              if(str.equals(passwd)) {unlockedFirst=unlockedSecond=true;}
              else if(str.charAt(0) == passwd.charAt(1)) unlockedSecond = true;
          }
      }
      
      if(unlockedFirst && unlockedSecond) System.out.println("YES");
      else System.out.println("NO");
    }  
}
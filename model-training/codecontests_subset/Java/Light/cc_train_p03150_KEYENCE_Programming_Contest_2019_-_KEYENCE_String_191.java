import java.util.*;
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String key = sc.next();
    int count = 0;
    String ans = "NO";
    
    if(key.equals("keyence")){
      ans = "YES";
    }else
    if('k'!=key.charAt(0)){
      count = 7;
    }else
    if('k'==key.charAt(0)&&'e'!=key.charAt(1)){
      count = 6;
    }else
    if('k'==key.charAt(0)&&'e'==key.charAt(1)&&'y'!=key.charAt(2)){
      count = 5;
    }else
    if('k'==key.charAt(0)&&'e'==key.charAt(1)&&'y'==key.charAt(2)
       &&'e'!=key.charAt(3)){
      count = 4;
    }else
    if('k'==key.charAt(0)&&'e'==key.charAt(1)&&'y'==key.charAt(2)
       &&'e'==key.charAt(3)&&'n'!=key.charAt(4)){
      count = 3;
    }else
    if('k'==key.charAt(0)&&'e'==key.charAt(1)&&'y'==key.charAt(2)
       &&'e'==key.charAt(3)&&'n'==key.charAt(4)&&'c'!=key.charAt(5)){
      count = 2;
    }else
    if('k'==key.charAt(0)&&'e'==key.charAt(1)&&'y'==key.charAt(2)
       &&'e'==key.charAt(3)&&'n'==key.charAt(4)&&'c'==key.charAt(5)
      &&'e'!=key.charAt(6)){
      count = 1;
    }else
    if('k'==key.charAt(0)&&'e'==key.charAt(1)&&'y'==key.charAt(2)
       &&'e'==key.charAt(3)&&'n'==key.charAt(4)&&'c'==key.charAt(5)
      &&'e'==key.charAt(6)){
      ans = "YES";
    }
    
    int last = key.length();
    
    if(count==1 && 'e'==key.charAt(last-1)){
      ans = "YES";
    }else
    if(count==2 && 'e'==key.charAt(last-1) && 'c'==key.charAt(last-2)){
      ans = "YES";
    }else
    if(count==3 && 'e'==key.charAt(last-1) && 'c'==key.charAt(last-2)
      && 'n'==key.charAt(last-3)){
      ans = "YES";
    }else
    if(count==4 && 'e'==key.charAt(last-1) && 'c'==key.charAt(last-2)
      && 'n'==key.charAt(last-3) && 'e'==key.charAt(last-4)){
      ans = "YES";
    }else
    if(count==5 && 'e'==key.charAt(last-1) && 'c'==key.charAt(last-2)
      && 'n'==key.charAt(last-3) && 'e'==key.charAt(last-4)
      && 'y'==key.charAt(last-5)){
      ans = "YES";
    }else
    if(count==6 && 'e'==key.charAt(last-1) && 'c'==key.charAt(last-2)
      && 'n'==key.charAt(last-3) && 'e'==key.charAt(last-4)
      && 'y'==key.charAt(last-5) && 'e'==key.charAt(last-6)){
      ans = "YES";
    }else
    if(count==6 && 'e'==key.charAt(last-1) && 'c'==key.charAt(last-2)
      && 'n'==key.charAt(last-3) && 'e'==key.charAt(last-4)
      && 'y'==key.charAt(last-5) && 'e'==key.charAt(last-6)
      && 'k'==key.charAt(last-7)){
      ans = "YES";
    }

    System.out.println(ans);
    
  }
}
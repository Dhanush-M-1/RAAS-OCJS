import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String keyence = "keyence";
    String str = sc.next();
    boolean judge = false;
    char[] carr = str.toCharArray();
    char[] key =keyence.toCharArray();
    for(int i=0;i<keyence.length();i++){
      if(carr[i]==key[i]){
        if(i==keyence.length()-1){
          judge = true;
        }
        continue;
      }else{
  //      for(int j=i+1;j<str.length();j++){
  //        if(carr[j]!=key[i]){
  //          continue;
  //        }else{
            if(keyence.substring(i).equals(str.substring(str.length()-(keyence.length()-i-1)-1))){
              judge = true;
            }
  //          break;
  //        }
  //      }
        break;
      }
    }
if(judge){
  System.out.println("YES");
}else{
  System.out.println("NO");
}
  }
}

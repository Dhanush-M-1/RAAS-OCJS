import java.util.*;
public class Test{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    String s = sc.next(); int max =0;String ans = "";
    for(int i=0;i+1<n1;i++){
      int count=0;
      StringBuilder sb = new StringBuilder((char)s.charAt(i)+""+s.charAt(i+1));
      for(int j=0;j+1<n1;j++){
        if(sb.charAt(0)==s.charAt(j) && sb.charAt(1)==s.charAt(j+1)){
          count++;
        }
      }
      if(count > max){
        max = count; ans = sb+"";
      }
    }
    System.out.println(ans);
}
}

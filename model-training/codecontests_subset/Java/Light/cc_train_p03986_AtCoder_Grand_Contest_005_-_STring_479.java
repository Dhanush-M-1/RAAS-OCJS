import java.util.*;
class Main{
  public static void main(String[]$){
    Scanner c=new Scanner(System.in);
    char[] x=c.next().toCharArray();
    int s=0;
    for(char t:x)s+=t=='S'?2:s>0?-2:0;
    System.out.print(s);
  }
}
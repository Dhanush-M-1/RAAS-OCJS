import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    int count=0;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='S'){
        count++;
      }else if(count>0){
        count--;
      }
    }
    System.out.println(count*2);
  }
}
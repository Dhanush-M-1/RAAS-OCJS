import java.util.*;

public class Main{
  public static final int N = 13;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    boolean[] cards = new boolean[N*4+1];
    int n = sc.nextInt(),num,i;
    String s;
    for(i = 1;i <= N*4;i++)cards[i] = false;
    for(i = 0;i < n;i++){
      s = sc.next();
      num = sc.nextInt();
      if(s.equals("S"))cards[num] = true;
      if(s.equals("H"))cards[N+num] = true;
      if(s.equals("C"))cards[N*2+num] = true;
      if(s.equals("D"))cards[N*3+num] = true;
    }
    for(i = 1;i <= N;i++){
      if(!cards[i])System.out.println("S " + i);
    }
    for(;i <= N*2;i++){
      if(!cards[i])System.out.println("H " + (i-N));
    }
    for(;i <= N*3;i++){
      if(!cards[i])System.out.println("C " + (i-N*2));
    }
    for(;i <= N*4;i++){
      if(!cards[i])System.out.println("D " + (i-N*3));
    }
    sc.close();
  }
}

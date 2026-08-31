import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner obj=new Scanner(System.in);
    int ac=0,wa=0,tl=0,re=0;
    int n=obj.nextInt();
    for(int i=0;i<=n;i++){
      String s=obj.nextLine();
      if(s.equals("AC"))
        ac++;
      else if(s.equals("WA"))
        wa++;
      else if(s.equals("TLE"))
        tl++;
      else if(s.equals("RE"))
        re++;
    }
    System.out.println("AC x "+ac+"\nWA x "+wa+"\nTLE x "+tl+"\nRE x "+re);
}
}
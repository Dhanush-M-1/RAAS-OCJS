import java.util.*;

class Main{

  public static void main(String args[]){

    Scanner s=new Scanner(System.in);
    int N=s.nextInt();
    int ans[]={0,0,0,0};
    for(int i=0;i<N;i++){
      String str=s.next();
      switch(str){
        case "AC": ans[0]+=1; break;
        case "WA": ans[1]+=1; break;
        case "TLE": ans[2]+=1; break;
        case "RE": ans[3]+=1; break;
      }
    }
    System.out.println("AC x "+ans[0]);
    System.out.println("WA x "+ans[1]);
    System.out.println("TLE x "+ans[2]);
    System.out.println("RE x "+ans[3]);
  }  
}
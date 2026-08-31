import java.util.Scanner;
class Main{
  public static void main(String args[]){
    Scanner scan=new Scanner(System.in);
    int num=scan.nextInt();
    int order[]=new int[num];
    int lev[]=new int[num];
    int plus[]=new int[num-1];
    int Ans=0;
    for(int a=0; a<num; a++){
      order[a]=scan.nextInt();
    }
    for(int a=0; a<num; a++){
      lev[a]=scan.nextInt();
    }
    for(int a=0; a<num-1; a++){
      plus[a]=scan.nextInt();
    }
    for(int a=0; a<num; a++){
      Ans+=lev[order[a]-1];
    }
    for(int a=1; a<num; a++){
      if(order[a]-order[a-1]==1){
        Ans+=plus[order[a-1]-1];
      }
    }
    System.out.println(Ans);
  }
}
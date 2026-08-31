import java.util.Scanner;
class Main
{
public static void main(String[] args)
 {
 Scanner sc = new Scanner(System.in);
  int  n  = sc.nextInt();
  int  i,j;
  boolean[][] card = new boolean[4][13];

 for(i=0;i<n;i++){
  char suit = sc.next().charAt(0);
  int num = sc.nextInt();
   switch(suit){
   case 'S': card[0][num-1]=true;
   break;
   case 'H': card[1][num-1]=true;
   break;
   case 'C': card[2][num-1]=true;
   break;
   case 'D': card[3][num-1]=true;
   break;
   }
}
   for(i=0;i<4;i++){
    for(j=0;j<13;j++){
     if(card[i][j]==false)System.out.println("SHCD".charAt(i)+" "+(j+1));
}

} 
 }
}
   



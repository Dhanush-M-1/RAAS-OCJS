import java.util.*;

class Main{

  public static boolean[][] cards=new boolean[4][13];
  static String a;
  static int b;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      int total = sc.nextInt();
      for (int i=0; i<total; i++) {
        a = sc.next();
        b = sc.nextInt();
        if (b == 0) {
          break;
          }
        cards[BoolChanger(a)][b-1] = true;
        }
      int j=0;
      while (j < 4) {
        for (int i=0; i<13; i++) {
          if (!cards[j][i]) {System.out.println(MarksChanger(j) + " " + (i+1));}
        }
          j++;
        } 
  }

  public static String MarksChanger(int k){
		switch(k){
		case 0:return "S";
		case 1:return "H";
		case 2:return "C";
		case 3:return "D";
		default:return null;
		}
  }
           
  public static int BoolChanger(String k){
		switch(k){
		case "S":return 0;
		case "H":return 1;
		case "C":return 2;
		case "D":return 3;
		default:return 0;
		}   
  }
}

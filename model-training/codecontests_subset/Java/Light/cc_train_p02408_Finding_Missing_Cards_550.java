import java.util.*;
public class Main {
    static Scanner kbd = new Scanner(System.in);
    public static void main(String[] args) {
 
    int t = kbd.nextInt();
    boolean[][] card = new boolean[13][4];
        //0:S 1:H 2:C 3:D
    int i;
    int j;
    for(i=0; i<t; i++){
        String m = kbd.next();
        int n = kbd.nextInt();
        card[n-1][mark(m)] = true;
    }
 
    for(j=0; j<4; j++){
        for(i=0; i<13; i++){
        if(card[i][j]==false)
            System.out.println(mark(j)+" "+(i+1));
        }
    }
    }
    static int mark(String m){
    if(m.equals("S")) return 0;
    if(m.equals("H")) return 1;
    if(m.equals("C")) return 2;
    return 3;
    }
    static String mark(int j){
    if(j==0) return "S";
    if(j==1) return "H";
    if(j==2) return "C";
    return "D";
    }
}
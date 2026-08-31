import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        
        boolean poss = false;
        for(int j=0;j<n;j++){
            if(poss){
                break;
            }
            for(int i=1;i<=((n-j)/4);i++){
                if(possible(s,j,i)){
                    //System.out.println(j+" "+i);
                    poss = true;
                    break;
                }
            }
        }
        if(s.length()<n){
            poss = false;
        }
        if(poss){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
    public static boolean possible(String s, int startIndex,int diff){
        int score = 0;
        //System.out.println(startIndex+" "+diff);
        for(int i=startIndex;i<s.length()&& i<startIndex+(5*diff);i+=diff){
            if(s.charAt(i)=='*'){
                score++;
            }else{
                return false;
            }
            if(score==5){
                break;
            }
        }
        //System.out.println(score);
        if(score==5)
        return true;
        else
        return false;
    }
}
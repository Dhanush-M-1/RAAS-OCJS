import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String key = "keyence";
        
        // if(s.subSequence(0, 7).equals(key)){
        //     System.out.println("YES");
        //     return;
        // }
        // if(s.subSequence(s.length()-7, s.length()).equals(key)){
        //     System.out.println("YES");
        //     return;
        // }

        int lnum = 0;
        int rnum = 0;
        for(int i=0; i<7; i++){
            if(s.charAt(i) == key.charAt(i)){
                lnum++;
            }else{
                break;
            }
        }
        for(int i=0; i<7; i++){
            if(s.charAt(s.length()-1-i) == key.charAt(key.length()-1-i)){
                rnum++;
            }else{
                break;
            }
        }

        if(lnum + rnum >= 7){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
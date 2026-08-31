import java.util.*;

public class MathematicsHurriesToTheRescue {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        String mat = scn.nextLine();
        char ch[] = new char[mat.length()];
        
        for(int i = 0; i < mat.length(); i++){
            ch[i] = mat.charAt(i);
        }
        
        for(int i = 0; i < ch.length; i=i+2){
            for(int j = ch.length-1; j>i; j=j-2)
            if(ch[i]>ch[j]){
                char t;
                t = ch[i];
                ch[i] = ch[j];
                ch[j] = t;
            }
        }
        
        System.out.print(ch);
    }    
}

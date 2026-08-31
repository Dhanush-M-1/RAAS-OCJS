import java.util.*;

public class Clas{
    public static void main(String[] st){
       Scanner s = new Scanner(System.in);
       String str = s.next();
       StringBuffer[] sts = new StringBuffer[3];
       for(int i = 0; i < 3; ++i) sts[i] = new StringBuffer("");
       for(char ch : str.toCharArray()){
           if(ch == '+') continue;
           else{
               if(ch == '1'){
                   if(sts[0].length() == 0) sts[0].append(ch);
                   else sts[0].append("+"+ch);
               }else if(ch == '2'){
                   if(sts[1].length() == 0) sts[1].append(ch);
                   else sts[1].append("+"+ch);
               }else if(ch == '3'){
                   if(sts[2].length() == 0) sts[2].append(ch);
                   else sts[2].append("+"+ch);
               }
           }
       }
       StringBuffer result = new StringBuffer("");
       for(int i = 0; i < 3; ++i){
           if(result.length() == 0){
               result.append(sts[i]);
           }else{
               if(sts[i].length() != 0){
                  result.append("+"+sts[i]); 
               }
           }
       }
       System.out.println(result.toString());
    }
    
}
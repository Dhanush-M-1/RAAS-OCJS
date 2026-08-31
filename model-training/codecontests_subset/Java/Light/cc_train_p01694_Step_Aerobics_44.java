import java.util.*;

class Main{           
  
   public static void main(String[] args){
         Scanner sc = new Scanner(System.in);  
         
         while(true){
             
             int n = sc.nextInt();
             int count = 0;
             if(n == 0){
                 break;
             }
             
             String S = "";
             for(int i = 0;i < n;i++){
                 S += sc.next();
             }
             S = S.replace("luru","h");
             S = S.replace("ldrd","h");
             S = S.replace("rulu","h");
             S = S.replace("rdld","h");
                  
             char s[]= S.toCharArray();
             
             for(int i = 0;i < s.length;i++){
                 if(s[i] == 'h'){
                     count++;
                 }
             }
             System.out.println(count);
         }
         
         
   }         
         
 }
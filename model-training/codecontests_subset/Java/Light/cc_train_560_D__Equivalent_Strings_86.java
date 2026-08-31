import java.util.*;
public class Main {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
                    
            String str1= sc.next();
            String str2= sc.next();
            
            if(equivalente(str1, str2))
                System.out.println("YES");
            else    System.out.println("NO");
        }

        public static boolean equivalente (String str1,String str2){
             if(str1.length()%2==1){
                if(str1.equals(str2)){
                    return true;
                }else{
                    return false;
                }
            }else{
                String s1=str1.substring(0,str1.length()/2);
                String s2=str1.substring(str1.length()/2);
                String s3=str2.substring(0,str1.length()/2);
                String s4=str2.substring(str1.length()/2);
                return ((equivalente(s1,s4))&&(equivalente(s2,s3)) ||(equivalente(s1,s3))&&(equivalente(s2,s4)));
            }
        }
}
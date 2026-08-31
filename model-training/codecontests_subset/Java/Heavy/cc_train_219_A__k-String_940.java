
import java.util.*;

public class tmp {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        
        int n =scan.nextInt();
        String s = scan.next();
        int [] arr = new int[26];
        
        for(int i=0; i<s.length(); i++)
            arr[s.charAt(i)-'a']++;
        for(int i=0; i<26; i++){
            if(arr[i]%n !=0){
                System.out.println("-1");
                System.exit(0);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(s.length()%n !=0){
            System.out.println("-1");
        }else{
            for(int i = 0; i < 26; i++){
                int k = arr[i]/n;
                while(k > 0){
                    sb.append((char)(i+'a'));
                    k--;
                }
            }
            for(int i=0; i<n; i++){
                System.out.print(sb.toString());
            }   
        }
        
        System.out.println();
        
        
        
        
          
        
        
        
        
        
    }
    
    
    
    
    
    
    


    
    
    
    
}



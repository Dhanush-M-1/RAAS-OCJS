
import java.util.*;
public class Twogram{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        
       
           int n = sc.nextInt();
            
           String s = sc.next();
           
          int res =0;
          int count =0;
          String ans="";
          //char ans;
          for(int i=0;i<n-1;i++){
              count =0;
              for(int j=0;j<n-1;j++){
                  if(s.charAt(i)==s.charAt(j) && s.charAt(i+1)==s.charAt(j+1)){
                      count++;
                      if(count>res){
                          res=count;
                          ans = s.substring(i,i+1) + s.substring(i+1,i+2);
                          //ans = s.charAt(i) + s.charAt(i+1);
                      }
                  }
              }
          }
           
           System.out.println(ans);
        
    }
}
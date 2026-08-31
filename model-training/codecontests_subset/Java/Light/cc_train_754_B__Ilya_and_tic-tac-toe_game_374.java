

 
import java.io.IOException;
 
 import java.util.*;

    public class Training {

      	  
       
            public static void main(String[] args) throws IOException {
 		Scanner input = new Scanner(System.in);
                 int [][]a= new int[8][8];
                 String answer = "NO";
               for(int i =2;i<6;i++){
                  String s= input.next();
                  for(int j=2;j<6;j++){
                      if(s.charAt(j-2)=='x'){
                          a[i][j]= 1;
                          
                      }else if(s.charAt(j-2)=='o'){
                          a[i][j]= -1;
                      }else if(s.charAt(j-2)=='.'){
                          a[i][j]=10;
                      }
                  }
               }
       
      for(int i =2;i<6;i++){
     for(int j =2;j<6;j++){
                         
        if ( a[i][j] + a[i][j+1] + a[i][j+2] == 12 )
        {
          answer = "YES";
        }
        if ( a[i][j] + a[i+1][j+1] + a[i+2][j+2] == 12 )
        {
          answer = "YES";
        }
        if ( a[i][j] + a[i+1][j] + a[i+2][j] == 12)
        {
          answer = "YES";
        }
        if ( a[i][j] + a[i-1][j+1] + a[i-2][j+2] == 12 )
        {
          answer = "YES";
        }
                        
         }
                } // end for 
             
      System.out.println(answer);
 
    
             } // end main
 
     
            
            
       
    } // end Class

import java.io.*;
import java.util.*;
public class main 
{
    
    
    
    
    
    
    public static void main(String[] args) throws Exception
         {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)) ;
            int t = Integer.parseInt(bf.readLine()) ;
            long ar=0 , ar2=0 ,ar3=0;
            StringTokenizer s= new StringTokenizer(bf.readLine()) ;
           for(int i = 0 ; i < t ; i++)
              ar += Long.parseLong(s.nextToken());
           s= new StringTokenizer(bf.readLine()) ; 
           for(int i = 0 ; i < t - 1 ; i++)
              ar2 += Long.parseLong(s.nextToken());
          s= new StringTokenizer(bf.readLine()) ;
           for(int i = 0 ; i < t - 2 ; i++)
              ar3 += Long.parseLong(s.nextToken());
             System.out.println(ar - ar2);
             System.out.println(ar2 - ar3);
         
         }
            
            
            
            }
                
         

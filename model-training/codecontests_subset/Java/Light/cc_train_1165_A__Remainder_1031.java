
/*
 *   
 *   Date: 07 September 2019
 *   Time: 01:03:00
*/
import java.io.*; 
import java.util.*;


   
public class remainder 
{
    public static void main(String[] args) throws NumberFormatException, IOException
    { 
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        String s=sc.next();
        int count=0;
        for(int i=n-x;i<n;i++){
          if(i!=n-y-1 && s.charAt(i)=='1'){
            count++;
          }
          if(i==n-y-1 && s.charAt(i)=='0'){
            count++;
          }
        }
        System.out.println(count);
      

    } 
} 
 
 
 

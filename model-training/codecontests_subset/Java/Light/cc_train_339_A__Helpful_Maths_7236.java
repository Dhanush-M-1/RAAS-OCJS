import java.util.*;
public class Solution {   
 public static void main(String[] args) {
     
        Scanner in = new Scanner(System.in);
        int j=0;
       String s=in.next();
       int l=s.length();
       int[] c1=new int[(l/2)+1];
       for(int i=0;i<l;i=i+2){
           int c=(int) s.charAt(i);
              c1[j]=c-48;
              j++;
          }
          Arrays.sort(c1);
           for(int k=0;k<j-1;k++){
               System.out.print(c1[k]);
               System.out.print("+");
               
           }
           System.out.print(c1[j-1]);
          }
   }
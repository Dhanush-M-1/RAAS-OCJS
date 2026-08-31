import java.io.*;
import java.util.*;
public class Main{
   public static void main(String[] args) throws IOException{
       
       ArrayList<String> arr=new ArrayList<>();
       
       BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       int idx=Integer.parseInt(bf.readLine());
       
       for(int i=0;i<idx;i++){
           arr.add(bf.readLine());
       }
       
       for(int i=1;i<14;i++){
           if(arr.contains("S "+i)==false)
               System.out.println("S "+i);
       }
       
       for(int i=1;i<14;i++){
           if(arr.contains("H "+i)==false)
               System.out.println("H "+i);
       }
       
       for(int i=1;i<14;i++){
           if(arr.contains("C "+i)==false)
               System.out.println("C "+i);
       }
       
       for(int i=1;i<14;i++){
           if(arr.contains("D "+i)==false)
               System.out.println("D "+i);
       }
   } 
}
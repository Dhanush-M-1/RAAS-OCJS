import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    static int printans (ArrayList mya, int size){
       int ans=0;
       for(int i=0;i<size-1;i++)
       {
           ans+=(int) mya.get(i);
       }
           return ans;
    }
       
    static public Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        
        int n=scan.nextInt();
        List <Integer>odd=new ArrayList();
        List <Integer>even=new ArrayList();
        
        for(int i=0;i<n;i++){
        
            int data=scan.nextInt();
            if(data%2==0)odd.add(data);
            else even.add(data);
        }
        if(Math.abs(odd.size()-even.size())<=1)System.out.println("0");
        else{
        
             Collections.sort(even);
             Collections.sort(odd);
             int size=Math.abs(even.size()-odd.size());
             System.out.println(even.size()>odd.size()? printans((ArrayList) even,size):printans((ArrayList) odd,size));
         
        }
      }
    
}


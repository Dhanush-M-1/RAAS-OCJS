import java.util.*;

public class Test{

    public static void main(String[] a__){
    
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-->0){
            
            int len = sc.nextInt();
            int[] a = new int[len];
            boolean isValid=false;
            
            for(int i=0; i<len; i++)
                a[i]=sc.nextInt();
            
            int f = a[len-1]-a[0];
            
            for(int i=1; i<len-1; i++){
            
                if(a[i]<=f){
                    
                    isValid=true;
                    System.out.println(1+" "+(i+1)+" "+len);
                    break;
                
                }
            
            }
            
            
            
            if(!isValid)
                System.out.println(-1);
            
            
        }
           
    
    }


}




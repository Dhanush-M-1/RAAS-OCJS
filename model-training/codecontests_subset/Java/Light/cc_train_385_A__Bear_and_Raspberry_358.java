import java.util.*;
public class A {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input =new Scanner (System.in);
        
        int n =input.nextInt();
        int c=input.nextInt();
        int[]arr=new int[n];
        int price =Integer.MIN_VALUE;
    
                
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        for (int i = 0; i < arr.length-1; i++) {
            
            int x=arr[i]-arr[i+1]-c;
           if(x>price)
           {
               price =x;
              
           }
        
        
        }
        if(price<0)
        {
            System.out.println("0");
        }else
        {
            System.out.println(price);
        }
        
        
        
    }

}

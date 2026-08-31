import java.util.*;

public class TwoSix{
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner (System.in);
        
        int t = scan.nextInt();
        
        for(int i=0; i<t; i++){
            int count = 0;
            int n = scan.nextInt();
            while(n>1){
                if(n%6==0){
                    n=n/6;
                }
                else if(n%3==0){
                    n=n*2;
                }
                else{
                    count = -1;
                    break;
                }
                count++;
            }
            
            System.out.println(count);
        }
    }
}
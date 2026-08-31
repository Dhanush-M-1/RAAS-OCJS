import java.util.*;

public class Stone{
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner (System.in);
        
        int t=scan.nextInt();
        for (int i=0; i<t;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c=scan.nextInt();
            int stones=0;
            while(c>=2){
                if (b>=1){
                    c=c-2;
                    b--;
                    stones =stones+3;
                }
                else{
                    break;
                }
            }
            while (b>=2){
                if(a>=1){
                    b=b-2;
                    a--;
                    stones=stones+3;
                }
                else{
                    break;
                }
            }
            System.out.println(stones);
        }
    }
}
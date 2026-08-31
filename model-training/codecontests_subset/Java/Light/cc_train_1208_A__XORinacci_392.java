import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int t=0;t<T;t++){
            int a=in.nextInt();
            int b=in.nextInt();
            int n=in.nextInt();
            
            if(n%3==0){
                System.out.println(a);
            }
            else if(n%3==1){
                System.out.println(b);
            }
            else{
                System.out.println(a^b);
            }
        }
        in.close();
    }
}
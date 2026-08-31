import java.util.*;
public class Solution{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int ans = 0;
            if(b==0)
            {
                System.out.println(0);
                continue;
            }
            else if(b==1){
                if(c>=2)
                  System.out.println(3);
                else
                  System.out.println(0);
                continue;
            }
            else{
                if(c>=2){
                    if(b>=c/2){
                        ans+=(c/2)*3;
                        b-=(c/2);
                    }
                    else{
                        ans+=b*3;
                        b=0;
                    }
                }
                if(b>=2){
                    if(a>=b/2){
                        ans+=(b/2)*3;
                        a-=(b/2);
                    }
                    else{
                        ans+=a*3;
                        a=0;
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
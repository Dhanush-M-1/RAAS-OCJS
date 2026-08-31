import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String s= sc.next();
        int x=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='8') x++;
        }
       // cout << min(8,n/11);
       int ans=Math.min(x,n/11);
       System.out.println(ans);
    }
}
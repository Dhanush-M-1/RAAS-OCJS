import java.util.*;
public class MinimumInteger {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int q=sc.nextInt();
        for(int z=0;z<q;z++){
            int l=sc.nextInt();
            int r=sc.nextInt();
            int d=sc.nextInt();
            long num;
            if(d>=l && d<=r){
                num= (int)(r/d);
                num= d*(num+1);
            }
            else 
                num=d;
            System.out.println(num);
        }
    }
}

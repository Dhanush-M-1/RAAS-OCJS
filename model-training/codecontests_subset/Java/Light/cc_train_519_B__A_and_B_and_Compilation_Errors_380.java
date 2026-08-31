import java.util.*;
public class error{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long sum=0;
        for (int i=0;i<n;i++) {
            sum+=s.nextInt();
        }
        long ans1=sum;
        for (int j=0;j<n-1;j++){
            ans1-=s.nextInt();
        }
        long ans2=sum-ans1;
        for(int i=0;i<n-2;i++){
            ans2-=s.nextInt();
        }
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
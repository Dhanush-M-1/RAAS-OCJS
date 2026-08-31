import java.util.*;

public class geek {



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a=s.nextInt();
     int b=s.nextInt();
     int mid=(a+b)/2;
    int ans1=Math.abs(mid-a);
    int ans2=Math.abs(mid-b);
    int ans=ans1*(ans1+1)/2+ans2*(ans2+1)/2;
        System.out.println(ans);



    }
    }


















import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int one=0;
        int two=0;
        for(int i=0;i<n;i++){
            int w= sc.nextInt();
            if(w==100)
                one++;
            else
                two++;
        }
        two=two%2;
        if(two>0)
            one-=2;
        if(one<0)
            System.out.println("NO");
        else{
            one=one%2;
            if(one>0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
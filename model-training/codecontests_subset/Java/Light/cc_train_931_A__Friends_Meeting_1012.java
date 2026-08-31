import java.util.*;
import java.lang.*;
public class Solution {
    public static void main(String args[]) {
    
        int x=0;int y=0;
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        float bla=Math.abs(a-b);
        if(bla%2==0){
            x=(int)bla/2;
            bla=(x*(x+1))/2;
            bla+=bla;
        }
        else{
            x=(int)Math.ceil(bla/2.0);
            //System.out.println("x "+x);
            y=x-1;
            bla=(x*(x+1))/2;
            y=(y*(y+1))/2;
            bla=bla+y;
        }
        System.out.println((int)bla);
    }
}
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        String s=sc.next();
        if(isGood(s)){System.out.println("1");System.out.println(s);}
        else {
            System.out.println("2");
        System.out.print(s.charAt(0)+" ");
        System.out.print(s.substring(1));
        }
    }
   static private boolean isGood(String str){
        int a=0,b=0;
        for(int i=0;i<str.length();i++)
        if(str.charAt(i)=='0')a++;
        else b++;
        if(a==b)return false;
        else return true;
    }
}
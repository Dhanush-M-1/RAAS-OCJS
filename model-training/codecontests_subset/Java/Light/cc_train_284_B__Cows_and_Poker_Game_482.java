//package CF_C2;
import java.util.*;
public class CB133{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        //System.out.println("SAKJJ");
        int n=ob.nextInt();
        String s=ob.next();
        int a=0,i=0,f=0;
        for(int j=0;j<n;j++){
            char ch=s.charAt(j);
            if(ch=='A') a++;
            else if(ch=='I') i++;
            else f++;
        }
        //System.out.println(a+" "+i+" "+f); 
        if(i==1)System.out.println("1");
        else if(i==0) System.out.println(a);
        else System.out.println("0");
    }
}
import java.util.*;
     
 public class Main
    {
     public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int l=s.nextInt(); int r=s.nextInt(); int d=s.nextInt();
            if(d<l || r<d) {
                System.out.println(d);
            }
            else {
                System.out.println((d*(r/d))+d);
            }
     }
     }
    }
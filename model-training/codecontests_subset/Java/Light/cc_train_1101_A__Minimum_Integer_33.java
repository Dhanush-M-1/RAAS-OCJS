import java.util.*;
public class A{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        for(int i=0;i<q;i++){
            int l=sc.nextInt(),r=sc.nextInt();
            int d=sc.nextInt();
            if(d<l){
                System.out.println(d);
            }
            else{
                System.out.println(r+d-(r%d));
            }
        }
    }
}
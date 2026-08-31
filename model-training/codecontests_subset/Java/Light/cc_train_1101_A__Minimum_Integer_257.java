import java.util.*;
public class a{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();

        while(t--!=0){

            long a=in.nextLong();
            long b=in.nextLong();
            long d=in.nextLong();
          
          if(d<a){
               System.out.println(d);
          }
          else{
            long mul=b/d+1;
            System.out.println(d*mul);
          }
        }
    }
}
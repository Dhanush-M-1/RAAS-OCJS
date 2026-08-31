import java.util.*;
 public class Main{
    public static void main (String args[])
    {
        Scanner in = new Scanner(System.in);
        int c1=in.nextInt(),c2=in.nextInt(),c3=in.nextInt(),c4=in.nextInt(),c5=in.nextInt();
        int sum=c1+c2+c3+c4+c5;
        if (sum%5==0 &&  sum!=0){
            System.out.println(sum/5);
        }
        else{
            System.out.println(-1);
        }
    }
}
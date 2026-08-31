
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.util.Arrays;







public class geek {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        try{


            int t=s.nextInt();

            StringBuffer sb=new StringBuffer();
            while (t-->0){
                int n=s.nextInt();
                long count=0;
                boolean flag=true;
                while(n!=1){
                    if(n%6==0){
                        n/=6;
                        count++;
                    }else if(n%3==0){
                        n*=2;
                        n/=6;
                        count+=2;
                    }else{
                        flag=false;
                        sb.append("-1\n");
                        break;
                    }
                }
                if(flag)sb.append(count+"\n");











            }
            System.out.println(sb);










            //solve.show(a);
            //  solve.show(b);





        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}











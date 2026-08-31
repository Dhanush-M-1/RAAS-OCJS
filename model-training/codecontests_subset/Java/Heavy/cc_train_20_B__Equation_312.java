

import java.io.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class B {
    BufferedReader bf;
    double value;

    public static void main(String[] args)throws IOException{
        B ob = new B();
        ob.do_();
        System.exit(0);
    }

    public void do_()throws IOException{
        bf = new BufferedReader( new InputStreamReader(System.in) );

        StringTokenizer st = new StringTokenizer( bf.readLine().trim() );
        DecimalFormat df = new DecimalFormat("0.0000000000000000000000");

        int A = nextI(st.nextToken());
        int B = nextI(st.nextToken());
        int C = nextI(st.nextToken());
        if(A==0 && B==0 && C==0){
            System.out.println(-1);
        }
        else if(A==0 && B==0){
            System.out.println(0);
       }
        else if(A==0 && C==0){
            System.out.println(1);
            System.out.format(df.format(0));
        }

        else if(A==0 && C!=0){
            System.out.println(1);
            System.out.println(df.format(-(double)C/B));
        }
        else{

            long tmp = (long)B*B - (long)A*C*4;
            if(tmp<0){
                System.out.println(0);
            }
            else{

                if(tmp==0){
                    System.out.println(1);
                    if(B==0){
                        System.out.println(df.format(0));
                    }
                    else{
                        System.out.println(df.format(-(double)B/ (2.0*A) ));
                    }
                }
                else{
                    System.out.println(2);
                    double[] tm = f2(A,B,C,tmp);
                    Arrays.sort(tm);
                    System.out.println(df.format(tm[0]));
                    System.out.println(df.format(tm[1]));
                }
            }

        }
    return ;
    }

    public double[] f2(int A,int B,int C, double res){
        res = Math.sqrt(res);
        double tmp1 = ( (double)(-B) + res ) / (2.0 * (double)A);
        double tmp2 = ( (double)(-B) - res ) / (2.0 * (double)A);

        double[] a = {tmp1,tmp2};

        return a;
    }

    public int nextI(String s){
        return Integer.parseInt(s);
    }
}

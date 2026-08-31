import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class mp {
    public static void main(String[] args) {
        Map< Integer,Integer>m1 = new HashMap<Integer, Integer>();
        Map< Integer,Integer>m2 = new HashMap<Integer, Integer>();
        Map< Integer,Integer>m3 = new HashMap<Integer, Integer>();
        //m1.put(100, 11);
        //m1.put(200,22);
        Scanner s=new Scanner(System.in);

        int l=s.nextInt();
        int []ar=new int[100000];
        int []br=new int[100000];
        //int []cr=new int[100000];


        for (int i=0;i<l;i++){
            int a=s.nextInt();
            ar[i]=a;
            int b;
            if(m1.get(a)==null){
                b=0;
            }
            else b=m1.get(a);


            b++;

            //System.out.println();
            //b++;
            m1.put(a,b);
        }
        for (int i=0;i<l-1;i++){
            int a=s.nextInt();
            br[i]=a;
            int b;
            if(m2.get(a)==null){
                b=0;
            }
            else b=m2.get(a);


            b++;

            //System.out.println();
            //b++;
            m2.put(a,b);


        }
        for (int i=0;i<l-2;i++){
            int a=s.nextInt();
            int b;
            //int b;
            if(m3.get(a)==null){
                b=0;
            }
            else b=m3.get(a);



            b++;
            m3.put(a,b);
        }

        for (int i=0;i<l;i++){
            int aa=ar[i];
            //int nn=m1.get(aa);

            if(!m1.get(aa).equals(m2.get(aa))){
                System.out.println(aa);
                break;
            }
        }
        for (int i=0;i<l-1;i++){
            int aa=br[i];
            //int nn=m2.get(aa);

            if(!m2.get(aa).equals(m3.get(aa))){
                System.out.println(aa);
                break;
            }
        }
        //System.out.println(m1.get(200));


    }
}
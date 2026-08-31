import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String[] ar = br.readLine().split(" ");
            int a = Integer.parseInt(ar[0]);
            int b = Integer.parseInt(ar[1]);
            int c = Integer.parseInt(ar[2]);
            int oa1 = a;
            int ob1 = b;
            int oc1 = c;
            int oa2 = a;
            int ob2 = b;
            int oc2 = c;
            int max = 0;
            int count =0;
            while(oa1>0){
                if(ob1>=2){
                    oa1--;
                    ob1=ob1-2;
                    count+=3;
                }else{
                    break;
                }
            }
            while(ob1>0){
                if(oc1>=2){
                    ob1--;
                    oc1=oc1-2;
                    count+=3;
                }else{
                    break;
                }
            }
            max = count;
            count =0;
            while(ob2>0){
                //System.out.println(ob2+" "+oc2);
                if(oc2>=2){
                    ob2--;
                    oc2=oc2-2;
                    count=count+3;
                }else{
                    break;
                }
            }
            while(oa2>0){
                if(ob2>=2){
                    oa2--;
                    ob2=ob2-2;
                    count=count+3;
                }else{
                    break;
                }
            }
            max = Math.max(max, count);
            System.out.println(max);
        }
        
    }
}
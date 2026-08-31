import java.io.*;
import java.util.*;
public class Ap2 {
    public static void main(String[] args)throws IOException {
         BufferedReader din=new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter dout=new BufferedWriter(new OutputStreamWriter(System.out));
         Integer s1[]=new Integer[100000];
         Integer s2[]=new Integer[100000];
         Integer s3[]=new Integer[100000];
         int size1,size2,size3;
         size1=Integer.parseInt(din.readLine());
         size2=size1-1;
         size3=size2-1;
         int error1=0,error2=0;
         String ss1=din.readLine();
         String ss2=din.readLine();
         String ss3=din.readLine();
         int sum1=0;
         int sum2=0;
         int sum3=0;
         StringTokenizer st1=new StringTokenizer(ss1);
        
         StringTokenizer st2=new StringTokenizer(ss2);
        
         StringTokenizer st3=new StringTokenizer(ss3);
        
         for(int i=0;i<size1;i++)
         {
            s1[i]=Integer.parseInt(st1.nextToken());
         sum1+=s1[i];
         }
          
         for(int i=0;i<size2;i++)
         {
            s2[i]=Integer.parseInt(st2.nextToken());
            sum2+=s2[i];
         }
          
         for(int i=0;i<size3;i++)
         {
            s3[i]=Integer.parseInt(st3.nextToken());
            sum3+=s3[i];
         }
         System.out.println(sum1-sum2);
         System.out.println(sum2-sum3);
         
    }
    
}
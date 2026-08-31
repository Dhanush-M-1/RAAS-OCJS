import java.io.*;
import java.util.*;

public class housie{   
     public static void main(String[]args) throws IOException {             
                 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                 PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
                 BufferedWriter bw=new BufferedWriter(pw);
                 int n=Integer.parseInt(br.readLine());
                 String s2=br.readLine();
                 int temp=0,d=0;
                 for(int i=0;i<n;i++){
                     if(s2.charAt(i)=='*'){
                         for( d=1;d<n;d++){
                             int count=0;
                             for(int j=i+d;j<n;j+=d){
                                 if(s2.charAt(j)!='*'){
                                    count=0;
                                     break;
                                 }
                                 else{
                                     count++;
                                 }
                                 if(count==4){
                                   //  System.out.println(j);
                                     temp=1;
                                     break;
                                 }
                             }
                             if(temp==1){
                                 break;
                             }
                         }
                     }
                     if(temp==1){
                       //System.out.println(d);
                         break;
                     }
                 }
                 
                 if(temp>0){
                     pw.print("yes");
                 }
                 else{
                     pw.print("no");
                 }
                 
                     
                pw.flush();
      }
}
                
                
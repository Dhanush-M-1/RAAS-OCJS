
import java.io.*;
import java.util.*;
public class Main {      //Name-rahul kumar                   //roll no:-2016073
    /*static int func(int n,int m,int h){
            h++;
            n--;
        if(h%m==0){
              n++;
            }
        if(n==0){
          return h;
        }
        if(m==1){
          return -1;
        }
        else{  
          return func(n,m,h);
        }
    }*/

    public static void main(String[] args) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String s[]=in.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);
        String str[]=in.readLine().split(" ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int c=Integer.parseInt(str[i]);
            arr[i]=c; 
        }
        Arrays.sort(arr);
        int d=-1;
        for(int i=0;i<n;i++){
           if(k%arr[i]==0) {
               d=arr[i];
           }
        }
        int c=k/d;
        System.out.println(c);
     }
   }



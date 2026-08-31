import java.io.*;
import java.util.*;
import java.lang.*;
public class a {
    static BufferedReader br;
    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));

         String[] ns = cinA();
         int n  =getI(ns[0]);
         int s =  getI(ns[1]);

         Integer[] arr  = new Integer[n];
         String[] data =cinA();

         for(int i =0;i<n;i++){
         	arr[i] =getI(data[i]);
         } 
               
        Arrays.sort(arr);

         int mid = (n)/2;

         if(arr[mid]==s){
         	cout("0");
         }
         else if(arr[mid]>s){

         	long  count = Math.abs(arr[mid]-s);

         	for(int j=mid-1;j>=0;j--){

         		if(arr[j]>s){
         			count+=Math.abs(arr[j]-s);
         		}
         		else{
         			break;
         		}
         	}
         	cout(String.valueOf(count));
         }
         else{
         	long count = Math.abs(arr[mid]-s);
         	for(int j=mid+1;j<n;j++){

         		if(arr[j]<s){
         			count+=Math.abs(arr[j]-s);
         		}
         		else{
         			break;
         		}
         	}
         	cout(String.valueOf(count));
         }


    }

 public static String cin() throws Exception {
        return br.readLine();
    }

    public static String[] cinA() throws Exception {
        return br.readLine().split(" ");
    }


    public static String ToString(Long x) {
        return Long.toBinaryString(x);
    }

    public static void cout(String s) {
        System.out.println(s);
    }
    public static Integer cinI() throws Exception {
        return Integer.parseInt(br.readLine());
    }
    public static int getI(String s) throws Exception {
        return Integer.parseInt(s);
    }
    public static int max(int a, int b) {
        return Math.max(a, b);
    }
    public static Long cinL() throws Exception {
        return Long.parseLong(br.readLine());
    }

}
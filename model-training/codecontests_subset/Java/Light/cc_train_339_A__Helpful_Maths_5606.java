import java.util.Scanner;

public class Helpful_Maths {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();String ns = "";
        int n=0;int temp = 0;
        int[] a = new int[(s.length()+1)/2];
        for(int i=0;i<s.length();i+=2){
           a[n] = Integer.parseInt(String.valueOf(s.charAt(i)));
           ++n;
        }
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j]= temp;
                }
            }
        }
        for (int i : a) {
            ns += String.valueOf(i) + "+";
        }
        System.out.println(ns.substring(0,s.length()));
    }
}

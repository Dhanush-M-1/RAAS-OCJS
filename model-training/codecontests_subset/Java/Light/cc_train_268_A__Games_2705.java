import java.util.Scanner;
 public class Main {
 public static void main( String[] args ) {
   Scanner s = new Scanner(System.in) ;
   int n = s.nextInt(),count = 0 ;
   int x[]=new int[n];
   int y[]=new int[n];
   for(int i=0;i<n;i++){
   x[i]=s.nextInt();
   y[i]=s.nextInt();
 }
   for(int l=0;l<x.length;l++){
   for(int m=0;m<y.length;m++){
   if(l!=m && x[l]==y[m] ){
   count++;
 }
 }
 }
   System.out.println(count);
 }
 }

import java.util.*;
public class rebus{
public static void main(String[]args){
Scanner input =new Scanner(System.in);
String s = input.nextLine();
String[] line = s.split(" ");
int n = Integer.parseInt(line[line.length-1]) , size = (line.length-1)/2;
int a[]  = new int[size] , r = 1;
a[0] = 1;
for(int i = 1 ; i < size; i++){r+= (a[i] = ((line[2*i-1].equals("+")) ? 1 : -1));}
r = n-r;
for(int i = 0 ; i < size;i++){
if(r * a[i] > 0 && a[i] > 0){
a[i] += (r >= n) ? (n-1) : r;
r -=  (r >= n) ? (n-1) : r;}
else if(r * a[i] > 0 && a[i] < 0){
a[i] += (r <= -n) ? 1-n : r;
r -=  (r <= -n) ? 1-n : r;}
}
if(r != 0) System.out.println("Impossible");
 else {System.out.println("Possible");
   for(int i = 0; i < size;i++) System.out.print(Math.abs(a[i]) + " " + line[2*i+1] + " ");
System.out.print(n+"\n");    
   }                                                                           
}
}
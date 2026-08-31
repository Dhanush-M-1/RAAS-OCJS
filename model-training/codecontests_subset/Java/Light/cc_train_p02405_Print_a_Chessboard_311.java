
import java.util.*;

class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int W,H;
for(;;){
H =sc.nextInt();
W =sc.nextInt();
if(H == 0) break;
for(int b=1; b<=H; b++){
if(b%2 ==0){
for(int a=1; a<=W; a++){
if(a%2 ==0) System.out.print("#");
else System.out.print(".");
}System.out.println();
}else{
for(int a=1; a<=W; a++){
if(a%2 ==0) System.out.print(".");
else System.out.print("#");
}
System.out.println();
}
}
System.out.println();
}
}
}
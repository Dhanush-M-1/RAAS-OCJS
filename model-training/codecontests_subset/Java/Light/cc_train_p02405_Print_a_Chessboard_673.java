import java.util.Scanner;

public class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
while(true){
int H = sc.nextInt();
int W = sc.nextInt();
if (W == 0 && H == 0) break;
for(int i=1;i<=H;i++){
for(int j=1;j<=W;j++){
if ((i+j) % 2 == 0){
System.out.printf("#");
}else{
System.out.printf(".");
}
}
System.out.println("");
}
System.out.println("");
}
sc.close();
}
}

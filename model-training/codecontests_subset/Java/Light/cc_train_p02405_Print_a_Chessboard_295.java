import java.util.*;
public class Main {
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
while(true){
int H=Integer.parseInt(sc.next());
int W=Integer.parseInt(sc.next());
if(H==0&&W==0){break;}

for(int j=0;j<H;j++){
    for(int i=0;i<W;i++){
    if(i%2==j%2)System.out.print("#");
    if(i%2!=j%2)System.out.print(".");
    }System.out.println();
}System.out.println();


}
}
}

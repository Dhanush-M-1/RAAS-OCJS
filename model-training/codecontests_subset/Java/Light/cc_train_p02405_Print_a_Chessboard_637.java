import java.util.Scanner;
public class Main{
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
int H,W,i,j,l;
while(true){

H=scan.nextInt();
W=scan.nextInt();
if(H==0&&W==0){

  break;
}else{
for(j=0;j<H;j++){
if(j%2==0){
 for(i=0;i<W;i++){

  if(i % 2==0){
    System.out.print("#");
  }else if(i % 2!=0){
    System.out.print(".");

  }

}
// System.out.println("");

}


else if(j%2==1){
for(l=0;l<W;l++){

 if(l % 2==0){
   System.out.print(".");
 }else if(l % 2!=0){

   System.out.print("#");
 }
}

}System.out.println("");
}

}
System.out.println("");
}
}
}

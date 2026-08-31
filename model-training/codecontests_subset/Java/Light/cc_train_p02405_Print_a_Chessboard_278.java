import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        while(true){
int H = sc.nextInt();
int W = sc.nextInt();
int i=0,k=0;

if(H==0&&W==0){
    break;
}

for(i=0;i<H;i++){
    for(k=0;k<W;k++){
        if((i+k)%2 == 0){
            System.out.printf("#");
        }else{
            System.out.printf(".");
    }
     
}   System.out.printf("\n"); 
    }
    System.out.printf("\n"); 
}
    }
}

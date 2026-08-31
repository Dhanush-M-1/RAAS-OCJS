import java.util.Scanner;
public class A1208 {
    public static void main(String[] argd){
Scanner input=new Scanner(System.in);

int ts;
ts=input.nextInt();
       int j;
for(int i=0;i<=ts-1;i++){
    int a,b,n;
    a=input.nextInt();
    b=input.nextInt();
    n=input.nextInt();
    j=n%3;
    switch(j){
        case 0:
            System.out.println(a);
            break;
        case 1:
            System.out.println(b);
            break;
        case 2:
            System.out.println(a^b);
            break;
    }
}


input.close();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        int rec=0;		//????????¢?????°
        int rho=0;		//????????¢?????°

        while(sc.hasNext()){
            String[] st=sc.next().split(",");
            int a=Integer.parseInt(st[0]);
            int b=Integer.parseInt(st[1]);
            int c=Integer.parseInt(st[2]);

            if(a==b){
            	rho++;
            }
            if(a*a+b*b==c*c){
            	rec++;
            }
        }
        System.out.println(rec);
        System.out.println(rho);
    }
}
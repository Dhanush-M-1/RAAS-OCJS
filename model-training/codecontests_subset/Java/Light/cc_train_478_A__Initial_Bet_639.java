

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();
        int d=scanner.nextInt();
        int e=scanner.nextInt();
        if(a+b+c+d+e>0&&(a+b+c+d+e)%5==0 )
            System.out.println((a+b+c+d+e)/5);
        else
            System.out.println(-1);
    }
}

 				 					   	 				  							 	
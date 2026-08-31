import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int p=n;
    int m=sc.nextInt();
    int count=0;
    while(n/m>0)
    { 
        int r=n/m;
        int g=n%m;
       
        count=count+r;
        n=r+g;
        
    }
        System.out.println(p+count);
      
    }
    }

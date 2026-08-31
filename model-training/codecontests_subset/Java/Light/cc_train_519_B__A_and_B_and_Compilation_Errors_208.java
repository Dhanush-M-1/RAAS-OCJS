import java.util.*;
public class Main {

    public static void main(String[] args) {
	Scanner sc=new Scanner (System.in);
        int n=sc.nextInt(),t=0,s=0,k=0;
        for(int i=0;i<n;i++)t+=sc.nextInt();
        for(int i=0;i<n-1;i++)k+=sc.nextInt();
        for(int i=0;i<n-2;i++)s+=sc.nextInt();
        System.out.println(t-k);
        System.out.println(k-s);
    }
}

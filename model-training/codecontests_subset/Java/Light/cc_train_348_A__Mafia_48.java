import java.util.Scanner;
public class C16 {
    public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int m=-1;
 int n=sc.nextInt(); long s=0;for (int i=0;i<n;i++){
     int t=sc.nextInt();
     if (t>m)m=t;
     s+=t;
 }
 long r=s%(n-1)==0?s/(n-1):s/(n-1)+1;
 if (r>=m)
 System.out.println(r);
 else System.out.println(m);
    }}
 


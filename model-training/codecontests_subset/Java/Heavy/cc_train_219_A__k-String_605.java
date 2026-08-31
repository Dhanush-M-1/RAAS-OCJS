import java.util.*;
import java.lang.Math;
public class AbstractionInJava{
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();
    String s=sc.nextLine();

    char[] a=new char[s.length()];
a=s.toCharArray();
char q=0;
    Arrays.sort(a);
    int count=0;

    for(int i=0;i<s.length();i++){
        if(i%n==0){
             q=a[i];
        }

        if(a[i]==q){
            count++;
        }
    }

    if(count==s.length() && count%n==0){
        for(int i=0;i<n;i++){
            for(int j=0;j<s.length();j=j+n){
                System.out.print(a[j]);
            }
        }
    }
    
    else System.out.print(-1);
 
    



    }}


        

       




      

import java.util.*;
public class Main{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
int t = sc.nextInt();
for (int i=0; i<t; i++) {
	int n = sc.nextInt();
    int count=0;
    while (n!=1) {
        if (n>1 && n%6!=0) {
            n=n*2;
            count+=1;
        }
        else if(n>1 && n%6==0) {
            n=n/6;
            count+=1;
        }
     
        else if (n<1){
    	count=-1;
    	break;
    
    }
}System.out.println(count);
}}}
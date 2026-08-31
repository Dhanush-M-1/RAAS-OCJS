import java.util.*;
public class pangram {
public static void main(String[]args){
	Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();int b=n;
	    int k=sc.nextInt();
	    PriorityQueue<Integer>x=new PriorityQueue<>();
	while(n>0){
		x.add(sc.nextInt()*-1);
		n--;
	}
for(int i=0;i<b;i++){
	int y=x.remove()*-1;
	if(k%y==0){
	System.out.println(k/y);break;
}
    }
}}
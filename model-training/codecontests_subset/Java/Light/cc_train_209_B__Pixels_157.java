import java.util.*;
public class Main {
public static void main(String [] args){
        Scanner in=new Scanner(System.in);	
        long array[]=new long[3];
        for(int i=0;i<=2;i++){
        array[i]=in.nextLong();	
        }
        Arrays.sort(array);
        if(array[1]%2==array[0]%2){
        	System.out.print(array[1]);
        	return;
        }
        System.out.print(array[2]);
}
}
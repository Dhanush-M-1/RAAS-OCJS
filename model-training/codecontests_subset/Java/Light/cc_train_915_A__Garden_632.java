import java.util.Arrays;
import java.util.Scanner;

public class abc {
	public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i,j=101,k = sc.nextInt();
        while(n>0){
        	n--;
        	i=sc.nextInt();
        	if(k%i==0)
        		j=Math.min(j, k/i);
        }
        System.out.println(j);
    }
}
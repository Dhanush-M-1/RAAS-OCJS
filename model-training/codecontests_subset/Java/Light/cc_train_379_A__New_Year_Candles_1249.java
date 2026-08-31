import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;


public class CF {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		int count=in.nextInt();
		int b=in.nextInt();
		int i=0;
		int dead=0;
		while(i<count) {
			i++;
			dead++;
			if(dead==b) {
				count++;
				dead=0;
			}
		}
		System.out.println(count);
		
	}
}


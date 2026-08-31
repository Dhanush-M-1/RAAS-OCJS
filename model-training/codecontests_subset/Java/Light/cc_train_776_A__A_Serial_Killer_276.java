import java.io.*;
import java.util.*;

public class cf35{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String vic1 = sc.next();
		String vic2 = sc.next();
		//sc.nextLine();
		System.out.println(vic1+" "+vic2);
        int t = Integer.parseInt(sc.next());
        
        while(t-->0){
           String mur = sc.next();
           String rep = sc.next();

           if(vic1.equals(mur)){
              vic1 = rep;
           }
           else{
           	 vic2 = rep;
           }

           System.out.println(vic1+" "+vic2);
        }

	}
}
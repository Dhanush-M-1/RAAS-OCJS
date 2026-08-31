import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
 
	int t = Integer.parseInt(in.next());

	while(t-- > 0){
		int a = Integer.parseInt(in.next()), b = Integer.parseInt(in.next()),c = Integer.parseInt(in.next());
        
        int count = 0;
        while(b > 0 && c >1){
                count+=3;
                b--;
                c-=2;

        }

        while(a > 0 && b > 1){
                count+=3;
                a--;
                b-=2;


        }

        out.println(count);



	} 

	out.close();
    }
}

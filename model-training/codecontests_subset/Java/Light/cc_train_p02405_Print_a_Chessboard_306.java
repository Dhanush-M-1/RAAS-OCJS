import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		
		while(true) {
			int H=in.nextInt(),W=in.nextInt();
			if(H==0)break;
			for(int i=1;i<=H;i++) {
				for(int j=1;j<=W;j++) {
					if((i%2==1 && j%2==1) || (i%2==0 && j%2==0))out.print("#");
					else out.print(".");
				}
				out.println();
			}
			out.println();
		}
		
		out.flush();
	}

}


import java.io.*;
import java.util.*;

public class zepta {
	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(new File("zepta.in"));
		//PrintStream out = new PrintStream(new File("zepta.out"));
		Scanner in = new Scanner(System.in);
			in.nextLine();
			String temp = in.nextLine();
			char[] w = new char[temp.length()];
			for(int i=0;i<temp.length();i++)
				w[i]=temp.charAt(i);
			boolean possible = false;
			for(int j = 0;j<w.length;j++){
				for(int k = 1;k<w.length;k++){
					boolean ihatecs=true;
					for(int a=0;a<5;a++)
					{
						if(!(j+k*a<w.length&&w[j+k*a]=='*')){
							ihatecs = false;
						}

					}
					if(ihatecs)
						possible = true;
				}
			}	
			if(possible)
				System.out.println("yes");
			else
				System.out.println("no");
			
		
	}
}
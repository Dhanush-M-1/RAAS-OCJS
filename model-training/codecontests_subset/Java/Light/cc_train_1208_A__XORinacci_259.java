import java.io.IOException;
import java.util.Scanner;

public class Xorinacci {
    
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        new Xorinacci().run();
    }

    public void run() throws NumberFormatException, IOException
    {
    	Scanner file = new Scanner(System.in);
    	int N = file.nextInt();
    	for(int i = 0;i<N;i++)
    	{
    		int a = file.nextInt();
    		int b = file.nextInt();
    		int c = file.nextInt();
    		if(c%3==0)
    			System.out.println(a);
    		else if(c%3==1)
    			System.out.println(b);
    		else
    			System.out.println(a^b);
    	}
    }
}
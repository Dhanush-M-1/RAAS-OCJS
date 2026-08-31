import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class AandBCompilation {
public static void main(String[] args) throws IOException {
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	bf.readLine();
	String x=bf.readLine();
	String [] y=x.split(" ");
	 x=bf.readLine();
	String [] z=x.split(" ");
	boolean flag=false;
	 x=bf.readLine();
	String [] p=x.split(" ");
	Arrays.sort(y);
	Arrays.sort(z);
	Arrays.sort(p);
	for(int i=0;i<y.length;i++)
	{
		if(i==(y.length-1))
		{
			System.out.println(y[i]);
			break;
		}
		if(!y[i].equals(z[i]))
		{
			System.out.println(y[i]);
			break;
		}
	}
	for(int i=0;i<z.length;i++)
	{
		if(i==(z.length-1))
		{
			System.out.println(z[i]);
			break;
		}
		if(!z[i].equals(p[i]))
		{
			System.out.println(z[i]);
			break;
		}
	}
}
}

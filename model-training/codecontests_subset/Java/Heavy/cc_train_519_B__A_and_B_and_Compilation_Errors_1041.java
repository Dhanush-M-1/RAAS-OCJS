import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class compilation
{

public static void main(String[] args) throws Exception
{

	Scanner in = new Scanner(System.in);
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
	int n= Integer.parseInt(inp.readLine());
	int[] a = new int[n];
	int[] b = new int[n-1];
	int[] c = new int[n-2];
	int i;
	int sum1=0;
	int sum2=0;
	int sum3 = 0;
	String n1 = inp.readLine();
	String[] x = n1.trim().split("\\s+");
	for ( i = 0; i < n; i++) {
    	a[i] = Integer.parseInt(x[i]);
	sum1+=a[i];
	}
	
	n1= inp.readLine();
        x = n1.trim().split("\\s+");

	for (i=0; i<n-1; i++)
	{
		b[i]= Integer.parseInt(x[i]);
		sum2+=b[i];

	}

	n1= inp.readLine();
        x = n1.trim().split("\\s+");

	for (i=0; i<n-2; i++)
        {
                c[i]= Integer.parseInt(x[i]);
                sum3+=c[i];

        }
	
	int x1= sum1-sum2;
	int x2= sum2-sum3;
	System.out.println(x1);
	System.out.println(x2);


	







}




}


import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
	Scanner In = new Scanner(System.in);

	int n = In.nextInt();

	int []a = new int[n];

	for(int i = 0; i < n; i++)
	     a[i] = In.nextInt();


	int count = 0;

	for(int i = 0; i < n - 1; i++)
	    {
		int minj = i;

		for(int j = i; j < n; j++)
		    {
			if(a[j] < a[minj])
			    {
				minj = j;
			
			    }
			
		    }	
		if(minj != i)
		    {
			int tmp = a[i];
			a[i] = a[minj];
			a[minj] = tmp;	
			count++;
		    }
	    }

	for(int i = 0; i < n - 1; i++)
	    System.out.print(a[i] + " ");

	System.out.println(a[n - 1]);
	System.out.println(count);
    

    }
}
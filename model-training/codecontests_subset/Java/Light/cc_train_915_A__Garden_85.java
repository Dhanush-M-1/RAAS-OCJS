import java.util.Scanner;

public class solution {

	public static void main(String[] args) {
		
		Scanner reader=new Scanner(System.in);

		int n=reader.nextInt();
		int k=reader.nextInt();
		int [] buckets=new int[n];
		int min=1000;
		for (int i=0;i<n;i++ ) 
		{

			int bucket=reader.nextInt();
			if (k%bucket==0 && k/bucket<min)
			{
				min=k/bucket;
			}


		}

		System.out.println(min);

	}
	
}
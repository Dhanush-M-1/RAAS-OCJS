import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TempTest
{

	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer count = 0;

		try
		{
			String[] array = br.readLine().split(" ");
			String min=array[0];
			String max = array[1];
			if(min.equals(max))
			{
				System.out.println(min);
			}else{
				System.out.println("2");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	}
import java.util.*;
public class H39 {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int b = input.nextInt();
	for(int i = 1; i<b; i++)
	{
		for(int j = 1; j<b; j++)
		{
			//cb(i*j, b);
			System.out.print(cb(i*j, b)+" ");
		}
		System.out.println();
	}
}
static int cb(int x, int b)
{
	int res = 0;
	int pow = 1;
	while(x > 0)
	{
		//System.out.println(x+" "+res+" "+pow);
		res += pow * (x%b);
		pow *= 10;
		x /= b;
	}
	return res;
}
}

import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class Woodcutters 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int trees = in.nextInt();
		Tree previous = null;
		int tot = 0;
		int lBound = 0;
		for(int a =0; a< trees; a++)
		{
			int position = in.nextInt();
			int height = in.nextInt();
			Tree n = new Tree(height, position);
			if(a == 0)
			{
			//	System.out.println(position + "!" + height);
				tot++;
				n.fellLeft();				
			}
			else if(!previous.fell && previous.p + previous.h < n.p)
			{
			//	System.out.println(position + "?" + height);
				tot++;
				previous.fellRight();
			}
			if(a != 0 && previous.endOccupy < n.p - n.h)
			{
				//System.out.println(position + "." + height);
				tot++;
				n.fellLeft();
			}
			previous = n;
		}
		if(!previous.fell)
			tot++;
		System.out.println(tot);
	}
}
class Tree
{
	int endOccupy;
	int h;
	int p;
	boolean fell;
	public Tree(int height, int pos)
	{
		h = height;
		p = pos;
		endOccupy = p;
		fell = false;
	}
	public int fellLeft()
	{
		endOccupy = p;
		fell = true;
		return p;
	}
	public int fellRight()
	{
		fell = true;
		endOccupy = p + h;
		return p + h;
	}
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		int n;
		
		while(true)
		{
			n = scan.nextInt();
			
			if(n == 0)
			{
				return;
			}
			else
			{
				new DataSet(n);
			}
		}
	}
	
	static class DataSet
	{
		int numOfWords;
		List<String> words = new ArrayList<String>();
		
		public DataSet(int numOfWords)
		{
			this.numOfWords = numOfWords;
			
			for(int i = 0; i < numOfWords; i++)
			{
//				System.out.println("Define word.");
				words.add(scan.next());
			}
			
			//now we get to work
			
			for(int sw = 0; sw < numOfWords; sw++) //sw = start word
			{
				if(checker(sw) == true)
				{
					//do away with this
					System.out.println(sw+1);
					return;
				}
			}
			System.out.println("0");
			
		}
		
		boolean checker(int startWord)
		{
			int curWord = startWord;
			//can he do it?
			for(int i = 1; i <= 5; i++)
			{
				//set requirements
				int reqLet;
				if(i == 1 || i == 3) {reqLet = 5;}else {reqLet = 7;}
				
				//fill the bucket.
				int bucket = 0;
				
				while(bucket < reqLet)
				{
					if(curWord+1 > words.size())
					{
						//out of words
						return false;
					}
					bucket += words.get(curWord).length();
					
					if(bucket > reqLet)
					{
						//SPILL!!
						return false;
					}
					
					curWord += 1;
				}
				
			}
			return true;
		}
		
	}

}


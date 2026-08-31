import java.util.Scanner;
public class many
{
	
	public static void main(String [] args)
	{
        Scanner input = new Scanner(System.in);
		
		int c = input.nextInt();
		input.nextLine();
		String s = input.nextLine();
		int arr[] = new int[10000];
        int	intIndex = 0;
        String arrS[] = new String[10000];
        int stringIndex = 0;		
		int max = 0;
		
		for(int i =0; i< (s.length()-1) ; i++)
		{
			String s2 = Character.toString(s.charAt(i)) + Character.toString(s.charAt(i+1));
			arrS[stringIndex] = s2;
			stringIndex++;
		}
		
		for(int i=0; i<stringIndex;i++)
		{
			int count =1;
			for(int j=i+1; j<stringIndex;j++)
			{
				if(arrS[i] != null){
				    if(arrS[i].equals(arrS[j])){
						count++;
					    arrS[j] = null;
					}
				}
			}
			arr[intIndex] = count;
			if(arr[intIndex] > arr[max])max = intIndex;
			intIndex++;
			
		} 
		 System.out.println(arrS[max]);
		 
		
		
	}
}
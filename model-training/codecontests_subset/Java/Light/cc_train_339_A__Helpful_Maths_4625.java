import java.util.Scanner;



public class mytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myS=new Scanner(System.in);

		String word =myS.next();
		
		char[] op = word.toCharArray();
		
		char z;
		
		for(int i=0;i<word.length();i++)
		{
			if(op[i]=='+')
			{
			}
			else 
			{
			z=op[i];
			
			for(int j=i+1;j<word.length();j++)
			{
				if(op[j]=='+')
				{
					
				}else
				{
					if(op[j]<z)
					{
						op[i]=op[j];
						op[j]=z;
						z=op[i];
					
						
					}
				}
				
			}
			
			}
			
		}
		
		
		
		System.out.println(op);
		
		

		
		

	}

}

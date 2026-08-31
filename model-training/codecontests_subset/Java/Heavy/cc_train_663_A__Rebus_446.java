/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public class equation2
{
	private String equationInput;
	private int positiveDigitsCount;
	private int negativeDigitsCount;
	private int rightSideValue;
	
	private int[] positiveValues;
	private int[] negativeValues;
	
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		equation2 objEquation= new equation2();
		objEquation.parseEquationString(input);
		
		if( objEquation.calculateTotalSolution() )
		{
			System.out.println("Possible");
			
			System.out.println(objEquation.getResultText());
		}
		else
		{
			System.out.println("Impossible");
		}
		
		
	}
	
	private void parseEquationString( String equationInput  )
	{
		this.equationInput= equationInput.replace(" ", "");
		
		int equestionMarksCount= getCharacterCount( this.equationInput, '?' );
		
		this.negativeDigitsCount= getCharacterCount( this.equationInput, '-' );
		
		this.positiveDigitsCount= equestionMarksCount - negativeDigitsCount;
		
		int indexOfEqualCharacter= this.equationInput.indexOf('=');
		
		this.rightSideValue= Integer.parseInt( this.equationInput.substring( indexOfEqualCharacter + 1 ) );
	}
	
	
	private boolean calculateTotalSolution()
	{
		positiveValues= new int[positiveDigitsCount];
		negativeValues= new int[negativeDigitsCount];
		
		Arrays.fill(positiveValues, 1);
		Arrays.fill(negativeValues, 1);
		
		int result= 1 * positiveValues.length - 1 * negativeValues.length;
		
		
		int arrayIndex= 0;
		while( result < rightSideValue && arrayIndex < positiveDigitsCount )
		{
			if( positiveValues[arrayIndex] < rightSideValue )
			{
				result ++;
				positiveValues[arrayIndex] ++;
			}
			else
			{
				arrayIndex ++;
			}
		}
		
		
		if( result < rightSideValue )
		{
			return false;
		}
		
		
		
		arrayIndex= 0;
		
		while( result > rightSideValue && arrayIndex < negativeDigitsCount )
		{
			if( negativeValues[arrayIndex] < rightSideValue )
			{
				result --;
				negativeValues[arrayIndex] ++;
			}
			else
			{
				arrayIndex ++;
			}
		}
		
		
		if( result > rightSideValue )
		{
			return false;
		}
		
		
		return true;
		
	}
	
	
	private String getResultText()
	{
		String resultText= equationInput;
		resultText= resultText.replace("-?", " - ?");
		resultText= resultText.replace("+?", " + ?");
		resultText= resultText.replace("=", " = ");

		for( int i=0; i < negativeDigitsCount; i ++ )
		{
			resultText= resultText.replaceFirst("\\- \\?" , "- " +  String.valueOf(negativeValues[i]) );
		}
		
		
		for( int i=0; i < positiveDigitsCount; i ++ )
		{
			resultText= resultText.replaceFirst("\\?" , String.valueOf(positiveValues[i]) );
		}
		
		
		return resultText;
	}
	
	private int getCharacterCount( String input, char searchCharacter )
	{
		return input.length() - input.replace( Character.toString(searchCharacter), "" ).length();
	} 
	
}

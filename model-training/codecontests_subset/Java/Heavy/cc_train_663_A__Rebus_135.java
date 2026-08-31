/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public class equation
{
	private String equationInput;
	private int positiveDigitsCount;
	private int negativeDigitsCount;
	private int rightSideValue;
	
	private int minPositiveTotalValue;
	private int maxPositiveTotalValue;
	private int maxNegativeTotalValue;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		equation objEquation= new equation();
		objEquation.parseEquationString(input);
		
		if( objEquation.isThereSolution() )
		{
			int[] totalSolution= objEquation.calculateTotalSolution();
			String resultText= objEquation.getResultText(totalSolution);
			
			System.out.println("Possible");
			System.out.println(resultText);
			
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
	
	private boolean isThereSolution( )
	{
		if ( this.positiveDigitsCount < 1   )
		{
			return false;
		} 
		
		minPositiveTotalValue= getMaxNumber( positiveDigitsCount, negativeDigitsCount + 1);
		maxPositiveTotalValue= rightSideValue * positiveDigitsCount;
		maxNegativeTotalValue= negativeDigitsCount * rightSideValue;

		
		if( maxPositiveTotalValue < minPositiveTotalValue || maxNegativeTotalValue < negativeDigitsCount )
		{
			return false;
		}
		else if(  (maxPositiveTotalValue - negativeDigitsCount) < rightSideValue )
		{
			return false;
		}
		else if( (minPositiveTotalValue - maxNegativeTotalValue) > rightSideValue )
		{
			return false;
		}
		
		return true;	
	}
	
	
	private int[] calculateTotalSolution()
	{
		int[] result= new int[2];
		
		int positiveTotalValueResult= maxPositiveTotalValue;
		int negativeTotalValueResult= negativeDigitsCount;
		
		int difference= positiveTotalValueResult - negativeTotalValueResult;
		
		//System.out.println("difference " + difference);
		
		
		if(  difference > rightSideValue )
		{
			positiveTotalValueResult -= (difference - rightSideValue);
			
			positiveTotalValueResult= getMaxNumber(positiveTotalValueResult, minPositiveTotalValue);
			
			difference= positiveTotalValueResult - negativeTotalValueResult;
			
			//System.out.println("difference " + difference);
		
			if( difference > rightSideValue )
			{
				negativeTotalValueResult += difference - rightSideValue;
			}
		}
/*
		System.out.println("positiveTotalValueResult " + positiveTotalValueResult);
		System.out.println("negativeTotalValueResult " + negativeTotalValueResult);
		*/ 
		result[0]= positiveTotalValueResult;
		result[1]= negativeTotalValueResult;
			
		return result;
		
	}
	
	private String getResultText(int[] totalSolution)
	{
		int totalPositiveSolution= totalSolution[0];
		int totalNegativeSolution= totalSolution[1];
		
		String resultText= equationInput;
		resultText= resultText.replace("-?", " - ?");
		resultText= resultText.replace("+?", " + ?");
		resultText= resultText.replace("=", " = ");

		if( negativeDigitsCount > 0 )
		{
			resultText= replaceEquationsWithNumbers( resultText, totalNegativeSolution, negativeDigitsCount, '-' );
		}
		
		resultText= replaceEquationsWithNumbers( resultText, totalPositiveSolution, positiveDigitsCount, '+' );
		
		return resultText;
	}
	
	private String replaceEquationsWithNumbers(String result, int totalValue, int marksCount, char signCharacter)
	{
		int markValue= totalValue / marksCount;
		int remainingeValue= totalValue % marksCount;
		
		for( int i=0; i < remainingeValue; i ++ )
		{
			result= result.replaceFirst("\\" + signCharacter + " \\?" , signCharacter + " " +  String.valueOf(1 +  markValue) );
		}
	
		result=  result.replace( signCharacter +  " ?",  signCharacter + " " + String.valueOf(markValue));
		
		
		if( signCharacter == '+' )
		{
			result= result.replaceFirst( "\\?",   String.valueOf(markValue));
		}
		
		return result;
	}
	
	
	private int getMaxNumber(int number1, int number2) 
	{
		if(number1 > number2){
			return number1;
		}
		else{
			return number2;
		}
	}
	
	
	private int getCharacterCount( String input, char searchCharacter )
	{
		return input.length() - input.replace( Character.toString(searchCharacter), "" ).length();
	} 
	
}

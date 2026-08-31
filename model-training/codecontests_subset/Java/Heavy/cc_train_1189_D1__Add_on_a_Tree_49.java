//package test;

import java.util.ArrayList;
import java.util.Scanner;

public class starter {
		
		public static void main ( String args[] )
		{
			Scanner conio = new Scanner ( System.in ) ;
			int size = conio.nextInt() , node1 , node2 ;
			
			ArrayList<Integer> holder [] = new ArrayList [size+1] ;
			
			while ( conio.hasNextInt() )
			{
				node1 = conio.nextInt() ;
				node2 = conio.nextInt() ;
				
				if ( holder[node1] == null )
					holder[node1] = new ArrayList<>() ; 
				if ( holder[node2] == null )
					holder[node2] = new ArrayList<>() ;
				
				holder[node1].add(node2) ;
				holder[node2].add(node1) ; 
			}
			
			boolean ans = false ; 
			
			for ( int i = 0 ; i <= size ; ++i )
				if ( holder[i] != null && holder[i].size() == 2 )
				{
					ans = true ;
					break ;
				}
			
			System.out.println( ans ? "NO" : "YES" ) ; 
			
			conio.close();  
		}
	

}



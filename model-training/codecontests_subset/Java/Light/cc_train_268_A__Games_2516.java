
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF268_D2_A
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner( System.in );
		
		int iN = scanner.nextInt();
		
		List< Integer > listHostTeamColorCode = new ArrayList<>();
		
		List< Integer > listGuestTeamColorCode = new ArrayList<>();
		
		int iOutput = 0;
		
		for( int i = 0; i < iN; i++ )
		{
			listHostTeamColorCode.add( scanner.nextInt() );
			
			listGuestTeamColorCode.add( scanner.nextInt() );
		}
		for( int iHostColorCode : listHostTeamColorCode )
		{
			for( int iGuestColorCode : listGuestTeamColorCode )
			{
				if( iGuestColorCode == iHostColorCode )
					iOutput++;
			}
		}
		System.out.println( iOutput );
		scanner.close();
	}
}
import java.util.Scanner;


public class FestApril2013C {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner kde = new Scanner (System.in);
	String S= kde.nextLine();
	int m= kde.nextInt();
	String St="";
	S=S.toLowerCase();
	for(int i=0; i<S.length(); i++ )
	{
	 char  k= S.charAt(i);
	 
	// if(k=='#') {k='A';}
	 if((k)<m+97) 
	 { St= St+(k+"").toUpperCase();}
	 else
	 { St= St+(k+"").toLowerCase();}    
	 
	}
	System.out.println(St);
    }

}

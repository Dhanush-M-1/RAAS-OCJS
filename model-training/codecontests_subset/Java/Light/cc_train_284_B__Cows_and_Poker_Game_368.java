import java.util.Scanner;


public class CodeforcesRound174B {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner kde = new Scanner(System.in) ;
	int t=kde.nextInt() ;
	String s=kde.next() ;
	int kol=0,flag=0;
	for(int i=0; i<s.length(); i++)
	{
	    if(s.charAt(i)=='A')
	    {
		kol++;
	    }
	    if(s.charAt(i)=='I')
	    {
		flag++;
	    }
	    
	}
	if(flag>1) 
	System.out.println(0);
	else
	if(flag==1) 
		System.out.println(1);
	else
	System.out.println(kol);    
    }

}

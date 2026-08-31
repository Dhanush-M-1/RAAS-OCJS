import java.util.*;
public class Main
{
	public static void main(String[] args) {
	Scanner kb=new Scanner(System.in);
	int t=kb.nextInt();
	while(t-->0)
	{int nbElem; nbElem=kb.nextInt();
	    int tab[]=new int[nbElem];

	    for (int i = 0; i < nbElem; ++i)
		    tab[i]=kb.nextInt();

	    int prefixEnd = -1, suffixEnd = nbElem;

	    for (int i = 0; i < nbElem; ++i) {
		    if (tab[i] < i) break;
		    prefixEnd = i;
	    }
	    for (int i = nbElem-1; i >= 0; --i) {
		    if (tab[i] < (nbElem-1)-i) break;
		    suffixEnd = i;
	    }

	    if (suffixEnd <= prefixEnd) 
		    System.out.println("Yes");
	    else
		    System.out.println("No");
	}
	}
}

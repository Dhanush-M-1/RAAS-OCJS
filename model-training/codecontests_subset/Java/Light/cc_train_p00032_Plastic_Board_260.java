import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	int hishi = 0;
	int tyouhou = 0;
	while(sc.hasNext()){
	    String[] line = sc.nextLine().split(",");
	    int hen1 = Integer.parseInt(line[0]);
	    int hen2 = Integer.parseInt(line[1]);
	    int hen3 = Integer.parseInt(line[2]);
	    if(hen1==hen2 && hen3>0){hishi++;}
	    else if(hen1*hen1+hen2*hen2==hen3*hen3){tyouhou++;}
	}

	System.out.println(tyouhou);
	System.out.println(hishi);
    }
}

import java.util.Scanner;
public class Watermelon {
    public static void main(String args[]){
        
        Scanner input=new Scanner(System.in);
        int countA=0;
        int countF=0;
        int countI=0;
        int n=input.nextInt();
        String state=input.next();
        char []c=new char[state.length()];
        c=state.toCharArray();
        
        
        for(int i=0;i<n;i++)
        {
        
            if(c[i]=='A')
                countA++;
            if(c[i]=='I')
                countI++;
            if(c[i]=='F')
                countF++;
        }
        if(countI==0)
            System.out.println(countA);
        else if(countI==1)
            System.out.println(countI);
        else
            System.out.print(0);
    
    }

}
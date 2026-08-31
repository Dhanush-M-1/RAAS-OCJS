import java.util.Scanner;
import java.util.Vector;


public class JavaApplication2 {
   
    
    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        String str =in.next();
        Vector <String> Original = new Vector<String>();
        Vector <String> Copy = new Vector<String>();
        for(int i=0 ; i<str.length()-1; i++)
            Original.add(str.charAt(i)+""+str.charAt(i+1));
            
        for(int i=0 ; i<Original.size(); i++)
            if(Copy.indexOf(Original.get(i))==-1)
                Copy.add(Original.get(i));
         
        int [] max = new int[Copy.size()];
        int count =0;
        
        for(int i=0 ; i<Copy.size(); i++)
        {
            for(int j=0; j<Original.size(); j++)
            {
                if(Copy.get(i).equals(Original.get(j)))
                    count++;
            }
            max[i]=count;
            count=0;
        }
        
        int m = max[0];
        int index=0;
        for(int i=1; i<max.length; i++)
            if(m < max[i])
            {
                m=max[i];
                index=i;
            }
                
       
        System.out.println(Copy.get(index));
}
}
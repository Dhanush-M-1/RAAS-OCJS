
import java.util.ArrayList;
import java.util.Scanner;

public class JavaApplication34 {

    public static void main(String[] args) {
        Scanner a=new Scanner(System.in);
        while(a.hasNext()){
            String pas=a.next();
            int n=a.nextInt();
            boolean find=false;
            ArrayList<String> p=new ArrayList<>();
            for(int i=0;i<n;i++){
                p.add(a.next());
            }
            if(p.contains(pas)){
                find=true;
            }
            for(int i=0;i<n;i++){
                String c2=String.valueOf(p.get(i).charAt(1));
                for(int j=0;j<n;j++){
                    String c1=String.valueOf(p.get(j).charAt(0));
                    String s=c2+c1;
                    if(s.equals(pas)){
                        find=true;
                    }
                }
            }
            
            if(find){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    
}

					   			 			   			  					 	
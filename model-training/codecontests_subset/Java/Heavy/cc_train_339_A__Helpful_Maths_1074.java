import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.*; 
public class Test  
{ 
    public static void main(String[] args) throws IOException  
    { 
		Scanner s=new Scanner(System.in);
		String problem = s.next();
		String[] test = problem.split("\\+");
		ArrayList<Integer> testInt = new ArrayList<>();
		for(int i = 0;i<test.length;i++){
			testInt.add(Integer.parseInt(test[i]));
		}
		Collections.sort(testInt);
		String solution = "";
		
		for(int i = 0;i<testInt.size();i++){
			if (i < testInt.size()-1){
				solution = solution + testInt.get(i) + "+";
			}else{
				solution = solution + testInt.get(i);
			}
		}
		System.out.println(solution);
    }
    
} 
import java.util.Scanner;
import java.util.Stack;

public class CF282C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		longestValidParentheses(in.nextLine());
	}
	public static void longestValidParentheses(String s) {
        char [] arr = s.toCharArray();
        Stack<Integer> stack = new Stack();
        StringBuilder w = new StringBuilder();
        Stack<Integer> hash = new Stack<Integer>();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]=='('){
                stack.push(i);
            }else if (arr[i]==')'){
            	if(!stack.isEmpty())
            		stack.pop();
            	else {
            		System.out.println(-1);
            		return;
            	}
            }else{
            	hash.push(i);
            }
        }
        int i = 0 ;
        for(int q = 0 ; q < hash.size() ; q++){
        	int j = hash.get(q);
        	int ans = 0;
        	for(; i < stack.size();){
        		if(stack.get(i)<j){
        			ans++;
        			i++;
        			if(q!=hash.size()-1)
        				break;
        		}
        		else break;
        	}
        	if(ans == 0){System.out.println(-1);
        	return;
        	}
        	else w.append(ans+"\n");
        }
        if(i != stack.size())System.out.println(-1);
        else
        System.out.println(w);
    }
}
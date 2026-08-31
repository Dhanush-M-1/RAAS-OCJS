import java.util.Scanner;


public class Main {
        public static void main(String[] args){
                Scanner sn = new Scanner(System.in);
                int n = sn.nextInt();
                for(int i = 0; i < n; i++){
                        System.out.println( decode(sn.next(),  sn.next()));
                }
        }

        static Message decode(String order, String msg){
        	Message m = new Message(msg);
                for(int i = order.length()-1; i >= 0; i--){
                        switch(order.charAt(i)){
	                        case 'J': m = m.c(); break;
	                        case 'C': m = m.j(); break;
	                        case 'E': m = m.e(); break;
	                        case 'A': m = m.a(); break;
	                        case 'P': m = m.m(); break;
	                        case 'M': m = m.p(); break;
                        }
                }
                return m;
        }
}

class Message{
        private String s;
        public String toString(){
                return s;
        }

        Message(String s){
                this.s = s;
        }

        Message j(){
                return new Message(s.substring(1)+s.charAt(0));
        }

        Message c(){
                return new Message(s.charAt(s.length()-1)+s.substring(0, s.length()-1));
        }

        Message e(){
                int half = s.length()/2;
                return  (s.length()%2==0)? new Message( s.substring(s.length()-half, s.length()) + s.substring(0, half)):
                        new Message( s.substring(s.length()-half, s.length()) + s.charAt(half) + s.substring(0, half));
        }

        Message a(){
                return new Message(new StringBuffer(s).reverse().toString());
        }

        Message p(){
                String ns = "";
                char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                for(int i = 0; i < s.length(); i++){
                        ns += (s.charAt(i) >= '0' && s.charAt(i) <= '9')? digits[s.charAt(i)-'0']:
                                s.charAt(i);
                }
                return new Message(ns);
        }

        Message m(){
                String ns = "";
                char[] digits = {'9', '0', '1', '2', '3', '4', '5', '6', '7', '8'};
                for(int i = 0; i < s.length(); i++){
                        ns += (s.charAt(i) >= '0' && s.charAt(i) <= '9')? digits[s.charAt(i)-'0']:
                                s.charAt(i);
                }
                return new Message(ns);
        }
}
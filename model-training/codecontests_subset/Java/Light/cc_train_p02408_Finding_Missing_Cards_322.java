import java.util.*;
import java.io.*;

class Card{
 char mark;
 int num;
 boolean have = false;
 static List<Card> allCards = new ArrayList<Card>();

 Card(char mark, int num){
	this.mark = mark;
	this.num = num;
	
}
}

public class Main{
public static void main(String[] args){

 char[] marks ={'S','H','C','D'};
 
	for(char mark: marks){
		for(int i = 0; i < 13; i++){
		 Card.allCards.add(new Card(mark, i+1));
		}
	}

	try{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(br.readLine());
	 	for(int a = 0; a < n; a++ ){
	  	 String[] str = br.readLine().split(" ");
		 	for(Card c : Card.allCards){
				if(c.mark != str[0].charAt(0)){
					continue;
				}
				if(c.num == Integer.parseInt(str[1])){
					c.have = true;
				}
			}
		}
	}catch(IOException e){
	 System.out.println(e);
	}

	for(Card c : Card.allCards){
		if(c.have == false){
		 System.out.println(c.mark + " " + c.num);
		}
	}
}
}
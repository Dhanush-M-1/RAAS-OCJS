import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wood {

    public static void main(String[] args) throws IOException{
	// TODO Auto-generated method stub
	Scanner file = new Scanner(System.in);
	//file = new Scanner(new File("wood.txt"));
	int trees = file.nextInt();
	int count = 0;
	int lastRight;
	int lastLeft;
	ArrayList<Point> tree = new ArrayList<Point>();
	for (int q = 0; q < trees; q++){
	    tree.add(new Point(file.nextInt(),file.nextInt()));
	}
	lastRight = -2;
	for (int w = 0; w < trees-1; w++){
	    int coord = tree.get(w).x;
	    int height = tree.get(w).y;
	    if (count==0){
		lastRight=coord;
		count++;
	    }
	    else
	    {
		if (coord-height>lastRight){
		    lastRight = coord;
		    count++;
		}
		else if (coord+height<tree.get(w+1).x){
		    count++;
		    lastRight = coord+height;
		}
		else{
		    lastRight=coord;
		}
	    }
	    
	}
	System.out.println(count+1);
    }

}

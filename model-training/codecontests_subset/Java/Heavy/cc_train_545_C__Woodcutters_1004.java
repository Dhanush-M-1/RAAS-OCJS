import java.util.*;
public class Woodcutters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTrees = sc.nextInt();
		sc.nextLine();
		HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();
		ArrayList<Integer> cords = new ArrayList<Integer>();
		
		for(int i = 0; i < numTrees; i++) {
			int cord = sc.nextInt();
			int height = sc.nextInt();
			cords.add(cord);
			input.put(cord, height);
			sc.nextLine();
		}
		
		if(cords.size() == 1) {
			System.out.println("1");
		} else {
			int fallen = 0;
			int rightVal = 1;
			int leftTree = Integer.MIN_VALUE;
			int rightTree = cords.get(rightVal);
			for(int i = 0; i < cords.size(); i++) {
				int treeCord = cords.get(i);
				if (leftTree < treeCord - input.get(treeCord)) {
					fallen++;
					leftTree = treeCord;
					rightTree = (++rightVal >= cords.size()) ? Integer.MAX_VALUE : cords.get(rightVal);
				} else if (rightTree > treeCord + input.get(treeCord)){
					fallen++;
					leftTree = treeCord + input.get(treeCord);
					rightTree = (++rightVal >= cords.size()) ? Integer.MAX_VALUE : cords.get(rightVal);
				} else {
					leftTree = treeCord;
					rightTree = (++rightVal >= cords.size()) ? Integer.MAX_VALUE : cords.get(rightVal);
				}
			}
			System.out.println(fallen);
		}

	}
	
	public static int getRight(int r, ArrayList<Integer> c) {
		return (r >= c.size()) ? Integer.MAX_VALUE : c.get(r);
	}

}

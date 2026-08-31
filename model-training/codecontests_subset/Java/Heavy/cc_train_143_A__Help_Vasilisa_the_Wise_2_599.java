public class Code {
	public static void main(String[] arg){
		java.util.Scanner input = new java.util.Scanner(System.in);
		byte[][] borders = new byte[3][2];
		for(byte i=0; i<6; i++)
			borders[i/2][i%2] = input.nextByte();
		byte[][] nums = new byte[2][2];
		/* using d1, r1 and r2 to fill nums and check for negative numbers and duplicates
		 * then check the rest with d2, c1 and c2
		 */
		do {
			nums[0][0]++;
			nums[1][1] = (byte)(borders[2][0] - nums[0][0]);
			nums[0][1] = (byte)(borders[0][0] - nums[0][0]);
			nums[1][0] = (byte)(borders[0][1] - nums[1][1]);
		}while(nums[0][0]<=9 && isNotSolved(borders,nums));
		if(isNotSolved(borders,nums))
			System.out.println("-1");
		else
			System.out.println(nums[0][0]+" "+nums[0][1]+"\n"+
								nums[1][0]+" "+nums[1][1]);
		input.close();
	}
	static boolean isNotSolved(byte[][] borders, byte[][] nums) {
		for(byte i=0; i<4; i++)
			if(nums[i/2][i%2] < 1 || nums[i/2][i%2] > 9)
				return true;
		for(byte i=0; i<4; i++)
			for(byte j=(byte)(i+1); j<4; j++)
				if(nums[i/2][i%2] == nums[j/2][j%2])
					return true;
		if( (nums[0][1]+nums[1][0] != borders[2][1])
			|| (nums[0][0]+nums[1][0] != borders[1][0])
			|| (nums[0][1]+nums[1][1] != borders[1][1]))
			return true;
		return false;
	}
}
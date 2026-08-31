import java.util.Scanner;

public class CodeForces7B {

	static boolean[] memory;
	
	public static boolean putBlock(Block[] blocks, Block x, byte m){
		return putBlock(blocks, x, m, 0);
	}
	
	public static boolean putBlock(Block[] blocks, Block x, byte m, int start){
		int i=start;
		while(i<=m-x.length){
			int j;
			for(j=0;j<x.length;j++){
				if(!memory[i+j]){
					break;
				}
			}
			if(j==x.length){
				blocks[x.id-1]=x;
				x.start=(byte) i;
				for(j=0;j<x.length;j++){
					memory[i+j]=false;
				}
				return true;
			}
			i+=j+1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		byte t = read.nextByte();
		byte m = read.nextByte();
		Block[] blocks = new Block[100];
		memory = new boolean[m];
		read.nextLine();
		for(int i=0;i<m;i++){
			memory[i]=true;
		}
		for(int i=0;i<t;i++){
			String[] s = read.nextLine().split(" ");
			switch(s[0]){
				case "alloc":{
					int space = Integer.parseInt(s[1]);
					if(space<0 || !putBlock(blocks, new Block(0, space), m)){
						System.out.println("NULL");
						Block.ID--;
					}
					else{
						System.out.println(Block.ID);
					}
					break;
				}
				case "erase":{
					int id = Integer.parseInt(s[1]);
					if(id<=blocks.length && id>0 && blocks[id-1]!=null){
						for(int j=0;j<blocks[id-1].length;j++){
							memory[blocks[id-1].start+j]=true;
						}
						blocks[id-1]=null;
					}
					else{
						System.out.println("ILLEGAL_ERASE_ARGUMENT");
					}
					break;
				}
				case "defragment":{
					int freeMemory=0;
					for(int j=0;j<Block.ID;j++){
						while(freeMemory<memory.length && !memory[freeMemory]){
							freeMemory++;
						}
						if(freeMemory>=memory.length){
							break;
						}
						//am ajuns pe prima pozitie libera si acum tre sa vad care e primul block dupa celula asta
						int k=0, iter;
						while(freeMemory+k<memory.length && memory[freeMemory+k]){
							k++;
						}
						if(freeMemory+k>=memory.length){
							break;
						}
						//acum am pozitia de start a primului block si tre sa-l gasesc in vectorul de blockuri
						//ca sa-l repozitionez pe pozitia freeMemory
						for(iter=0;iter<Block.ID;iter++){
							if(blocks[iter]!=null && blocks[iter].start==freeMemory+k){
								//sterge blockul si apoi pune-l pe freeMemory
								for(int temp=0;temp<blocks[iter].length;temp++){
									memory[blocks[iter].start+temp]=true;
								}
								putBlock(blocks, blocks[iter], m, freeMemory);
								freeMemory=blocks[iter].start+blocks[iter].length;
								break;
							}
						}
					}
					break;
				}
			}
		}
		read.close();
	}

}

class Block{
	static byte ID=0;
	byte length, start, id;
	Block(int i, int j){
		this.id = ++ID;
		this.length = (byte) j;
		this.start = (byte) i;
	}
}


/*
6 10
alloc 5
alloc 3
erase 1
alloc 6
defragment
alloc 6

answer:
1
2
NULL
3

10 10
alloc 5
alloc 3
erase 1
alloc 6
defragment
alloc 6
erase 1
alloc 1
defragment
alloc 1

answer:
1
2
NULL
3
ILLEGAL_ERASE_ARGUMENT
4
NULL

14 100
alloc 99
alloc 1
alloc 1
erase 2
alloc 1
erase 4
erase 1
alloc 100
alloc 1
alloc 99
defragment
erase 4
alloc 100
alloc 99

answer:
1
2
NULL
3
ILLEGAL_ERASE_ARGUMENT
NULL
4
NULL
NULL
NULL


*/
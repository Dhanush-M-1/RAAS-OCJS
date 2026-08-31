value = input("");
n = int(value);

answer = 1;
minTrees = 1;
maxTrees = pow(10,5);
if not(minTrees <= n <= maxTrees) :
	n = 1;
	
lastX = 0;
treesCut = 0;	
lastTree = "";

for key in range(0, n) :
	newTree = input("");
	if (n >= 3) :
		if (lastTree != "") :
			argv = lastTree.split(" ");
			x = int(argv[0]);
			h = int(argv[1]);
			toLeft = x - h;
			if (toLeft > lastX) :
				treesCut += 1;
				lastX = x;
			else :
				toRight = x + h;
				nextTree = newTree.split(" ");
				nextTreeX = int(nextTree[0]);
				if (toRight < nextTreeX) :
					treesCut += 1;
					lastX = toRight;
				else :
					lastX = x;	
					
			if (key == (n - 1) ) :
				treesCut += 1;
		else :
			argv = newTree.split(" ");
			x = int(argv[0]);
			h = int(argv[1]);
			lastX = (x - h) - 1;
	lastTree = newTree;
	
if (n < 3) :
	treesCut = n;

print(treesCut);

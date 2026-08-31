value = input("");
n = int(value); # number of trees

answer = 1;
minTrees = 1;
maxTrees = pow(10,9);
if not(minTrees <= n <= maxTrees) :
	n = 1;
	
mydict = {};
# get tree coordinate x, height
for x in range(0, n) :
	mydict[x] = input("");

# No trees, no option to catch
if (n < 3) :
	answer = n;
else :
	argv = mydict[0].split(" ");
	x = int(argv[0]);
	h = int(argv[1]);
	lastX = (x - h) - 1;
	treesCut = 0;
	for value in mydict:	
		argv = mydict[value].split(" ");
		x = int(argv[0]);
		h = int(argv[1]);
		toLeft = x - h;
		if (toLeft > lastX) :
			treesCut += 1;
			lastX = x;
		else :
			toRight = x + h;
			if (len (mydict) > (value + 1) ) :
				nextTree = mydict[value+1].split(" ");
				nextTreeX = int(nextTree[0]);
			else :
				nextTreeX = toRight + 1;
			if (toRight < nextTreeX) :
				treesCut += 1;
				lastX = toRight;
			else :
				lastX = x;			
	answer = treesCut;
	
# try cut down to the left first as cuting to right reduces posibillity to cut to left.
print(answer);
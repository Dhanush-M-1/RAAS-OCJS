import sys

tests = int(sys.stdin.readline())

for i in range(tests):
	msize = int(sys.stdin.readline())
	matrix = []
	for j in range(msize):
		line = sys.stdin.readline().strip()
		matrix.append(line)
	changes = []
	# Check parts surrounding S and F
	sr = int(matrix[0][1])
	sd = int(matrix[1][0])
	fl = int(matrix[msize-1][msize-2])
	fu = int(matrix[msize-2][msize-1])
	#print(f"{sr} {sd} {fl} {fu}")
	if sr == sd:
		# check finish
		if fl == sr:
			fl = (fl + 1) % 2
			changes.append(((msize),(msize-1)))
		if fu == sr:
			fu = (fl + 1) % 2
			changes.append(((msize-1),(msize)))			
	if sr != sd:
		# find out which to change
		if fl == fu:
				if sr == fl:
					sr = (fl + 1) % 2
					changes.append((1,2))
				else:
					sd = (fl + 1) % 2
					changes.append((2,1))			
		else:
			if sr == fl:
				# change sd and fl
				sd = (sd + 1) % 2
				changes.append((2,1))
				fl = (fl + 1) % 2
				changes.append(((msize),(msize-1)))
			else:
				# change sr and fl
				sr = (sr + 1) % 2
				changes.append((1,2))
				fl = (fl + 1)  % 2
				changes.append(((msize),(msize-1)))
	print(len(changes))
	for change in changes:
		print(f"{change[0]} {change[1]}")

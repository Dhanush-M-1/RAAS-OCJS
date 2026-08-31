def MisterBandBookReading(c,v0,v1,a,l):
	n = 0
	cntOfPagesRead = 0
	while cntOfPagesRead<c:
		PagesRead = v0 + n * a 

		if n!=0:
			PagesRead -= l

		if PagesRead <= v1:
			cntOfPagesRead += PagesRead
		else:
			cntOfPagesRead += (v1 - l)
		n+=1

	return n

def MisterBandBookReadingSolution(c,v0,v1,a,l):
	n = 1
	cntOfPagesRead = v0
	add = v0
	while cntOfPagesRead<c:
		add = min(v1,add+a)
		cntOfPagesRead += (add-l)
		n+=1

	return n


c,v0,v1,a,l = [int(x) for x in input().split()]
print(MisterBandBookReadingSolution(c,v0,v1,a,l))
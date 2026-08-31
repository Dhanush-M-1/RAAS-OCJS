def doit(d):
	
	if(d<l):
		return d
	else:
		if(r%d==0):
			return r+d
		else:
			return r+d-r%d
	

q=int(input())

for t in range(q):
	[l,r,d]=[int(i) for i in input().split()]

	print(doit(d))
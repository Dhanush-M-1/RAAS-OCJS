def qc(n,b):
	t,z=0,0
	while n>0:
		t+=n
		n=t//b-z
		z+=n
	return t

n,b=[int(x) for x in input().split()]
print(qc(n,b))
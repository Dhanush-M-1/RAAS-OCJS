for time in range(int(input())):
	l=int(input())
	op=[]
	rt=input().split()
	op=rt
	for er in range(l):
		op[er]=int(op[er])
	x=op[0]
	y=op[1]
	z=op[-1]
	if z>=x+y:
	    print(1,2,l)
	else:
	    print(-1)
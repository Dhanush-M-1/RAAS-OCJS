def read():
	l= [int(x) for x in input().split()]
	l.append(10**9+1)
	l.sort()
	return l

input()
i=[read() for s in [1,2,3]]

def diff(a,b):
	return next(x for x,y in zip(a,b) if x!=y)

print(diff(i[0],i[1]))
print(diff(i[1],i[2]))
r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
def f():
	for a in range(1,10):
		for b in range(1,10):
			for c in range(1,10):
				for d in range(1,10):
					if len(set([a,b,c,d]))==4:
						if r1==a+b and r2==c+d and c1==a+c and c2==b+d and d1==a+d and d2==b+c:
							return [1,a,b,c,d]
	return [0]
l=f()
if l[0]:
	print(l[1],l[2])
	print(l[3],l[4])
else:
	print(-1)
r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())

for r in range(1,10):
	for rr in range(1,10):
		for c in range(1,10):
			for cc in range(1,10):
				l=[r,rr,c,cc]
				if r+rr==c1 and r+c==r1 and r+cc==d1 and rr+c==d2 and rr+cc==r2 and len(set(l))==4:
					print(r,c)
					print(rr,cc)
					exit()
print(-1)

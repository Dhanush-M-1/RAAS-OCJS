t=int(input())
for z in range(t):
	l,r,n=map(int,input().split())
	if n*1>=l and n*1<=r:
		c=r//n
		print(n*(c+1))
	else:
		print(n*1)

t=int(input())
for i in range(t):
	n=int(input())
	a=list(map(int,input().split()))
	x=max(a)
	b=sorted(a)
	y=b[0]
	z=b[1]
	if y+z<=x:
		m=a.index(x)
		a[m]=0
		k=a.index(y)
		a[k]=0
		l=a.index(z)
		s=[m+1,k+1,l+1]
		print(*sorted(s))
	else:
		print(-1)
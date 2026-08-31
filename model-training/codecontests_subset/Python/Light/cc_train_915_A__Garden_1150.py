n,m=map(int,input().split())
l=list(map(int,input().split()))
c=0
for x in range(n):
	if m%l[x]==0:
		if l[x]>c:
			c=l[x]
print(m//c)
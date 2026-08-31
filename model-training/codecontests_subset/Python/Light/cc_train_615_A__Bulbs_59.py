n,m=map(int,input().split())
a=[0]*m
for i in range(n):
	x=list(map(int,input().split()))
	for i in range(1,x[0]+1):
		a[x[i]-1]=1
if sum(a)==m:
	print("YES")
else:
	print("NO")
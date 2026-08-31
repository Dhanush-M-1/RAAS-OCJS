a,b=map(int,input().split())
k=[]
for _ in range(a):
	c=list(map(int,input().split()))
	x=int(1)
	while x<=c[0]:
		k.append(c[x])
		x=x+1
k=list(set(k))
if len(k)==b and max(k)==b:
	print("YES")
else:
	print("NO")
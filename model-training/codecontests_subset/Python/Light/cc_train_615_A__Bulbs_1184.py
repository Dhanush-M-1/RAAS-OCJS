n,b=map(int,input().split())
l=[i for i in range(1,b+1)]
for i in range(n):
	c=list(map(int,input().split()))
	for j in range(len(c)-1):
		if c[j+1] in l:
			l.remove(c[j+1])
if len(l)==0:
	print("YES")
else:
	print("NO")				

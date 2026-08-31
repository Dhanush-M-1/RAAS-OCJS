n,m=map(int,input().split())
x=set()
for i in range(n):
	l=list(map(int,input().split()))
	for j in range(1,len(l)):
		x.add(l[j])
if(len(x)==m):
	print("YES")
else:
	print("NO")
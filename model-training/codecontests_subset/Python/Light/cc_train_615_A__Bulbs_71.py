n,m=map(int,input().split())
a={""}
for i in range(n):
	l=list(map(int,input().split()))
	for j in range(1,l[0]+1):
		a.add(l[j])
if len(a)==m+1:
	print("YES")
else:
	print("NO")
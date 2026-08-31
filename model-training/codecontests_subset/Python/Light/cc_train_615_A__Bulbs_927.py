n,m=map(int,input().split())
s=[]
for i in range(n):
	p=list(map(int,input().split()))
	for i in p[1::]:
		s.append(i)
if len(set(s))==m:
	print("YES")
else:
	print("NO")

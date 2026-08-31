n,m=map(int,input().split())
l=[]
for i in range(n):
	bon=list(map(int,input().split()))
	for i in range(bon[0]):
		l.append(bon[i+1])
s=set(l)
if len(s) == m:
	print("YES")
else:
	print("NO")
n,m=map(int,input().split())
a=[i for i in range(1,m+1)]
s=[]
for i in range(n):
	b=list(map(int,input().split()))
	del b[0]
	s+=b
s=set(s)
if len(s)==m:
	print("YES")
else:
	print("NO")	
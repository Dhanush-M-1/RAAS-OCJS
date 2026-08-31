n,m=map(int,input().split())
a=[]
for x in range(n):
	l=list(map(int,input().split()))
	for i in range(1,len(l)):
		a.append(l[i])
b=set(a)
if len(b)==m:print("YES")
else:print("NO")
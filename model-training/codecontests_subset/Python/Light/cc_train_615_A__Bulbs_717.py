t=list(map(int,input().split()))
l=[False for i in range (t[1])]
for i in range (t[0]):
	u=list(map(int,input().split()))
	k=1
	for j in range (1,u[0]+1):
		l[u[j]-1]=True
		k=k+1
if l.count(False)==0:
	print("YES")
else :
	print("NO")

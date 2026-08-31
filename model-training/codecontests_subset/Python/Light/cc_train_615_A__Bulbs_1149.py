n,m=map(int,input().split())
k=[i for i in range(1,m+1)]
y=[]
for i in range(n):
	x=list(map(int,input().split()))
	x.pop(0)
	for j in range(len(x)):
		y.append(x[j])
y=set(y)
y=list(y)
if(y==k):
	print('YES')
else:
	print('NO')
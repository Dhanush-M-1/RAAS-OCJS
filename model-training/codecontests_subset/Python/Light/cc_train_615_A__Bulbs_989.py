b=[]
n,m=map(int,input().split())
for i in range(n):
	x=list(map(int,input().split()))
	for i in range(1,len(x)):
		b.append(x[i])
# print(b)
if len(set(b))==m:
	print('YES')
else:
	print('NO')
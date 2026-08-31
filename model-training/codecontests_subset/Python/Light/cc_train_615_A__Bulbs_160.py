n,m=map(int,input().split())
b=[]
for i in range(n):
	a=list(map(int,input().split()))
	for i in a[1::]:
		b.append(i)
if m==len(set(b)):
	print('YES')
else:
	print('NO')
n,m=[int(x) for x in input().split()]
l=[]
t=0
for i in range(1,n+1):
	x,*y=input().split()
	for j in y:
		if j not in l:
			l.append(int(j))
for k in range(1,m+1):
	if k in l:
		t+=1
if t==m:
	print('YES')
else:
	print('NO')
n,m =map(int, input().split())
k=[]
for i in range(n):
	d=input().split()
	#d-=d[0]
	k+=d[1:]
	#print(k)
l=0
for j in range(1,m+1):
	if str(j) in k:
		l+=1
#print(l)
if l==m:
	print('YES')
else:
	print('NO')
	
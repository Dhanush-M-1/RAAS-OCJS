a=[int(n) for n in input().split()]
z=[]
for n in range(a[0]):
	b=[int(n) for n in input().split()]
	z+=b[1:]
k=[]
for n in z:
	if n not in k:
		k.append(n)
if len(k)!=a[1]:
	print('NO')
else:
	print('YES')	
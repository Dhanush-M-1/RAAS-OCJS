q=int(input())
ar=[]
for i in range(q):
	lrd=input().split()
	l=int(lrd[0])
	r=int(lrd[1])
	d=int(lrd[2])

	if d<l:
		valor=d
	elif (r+1)%d==0:
		valor=r+1
	else:
		valor=d*((r+1)//d+1)
	ar.append(valor)

print("\n".join(map(str,ar)))
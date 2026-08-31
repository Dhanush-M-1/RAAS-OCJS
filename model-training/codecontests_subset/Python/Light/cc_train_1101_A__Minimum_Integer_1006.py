x=int(input())
for i in range(x):
	a=input().split(" ")
	b=list(map(int, a))
	t=b[0]%b[2]
	p=int(b[0]/b[2])
	if t!=0 :
		if p >= 1 :
			req=b[2]
		else:
			req=b[1]+(b[2]-(b[1]%b[2]))
	else:
		if (b[0]-b[2])>0 :
			req=b[2]
		else:
			req=b[1]+(b[2]-(b[1]%b[2]))
	print(req)


r=[]
for _ in range(int(input())):
	a,b,c=list(map(int,input().split()))
	if c>=a:
		r.append(b+c-(b)%c)
	else:
		r.append(c)
for i in r:
	print(i)	


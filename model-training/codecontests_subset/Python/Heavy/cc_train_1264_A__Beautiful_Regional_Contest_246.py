for _ in range(int(input())):
	n=int(input())
	l=list(map(int,input().split()))
	d={}
	for i in l:
		if i in d:
			d[i]+=1
		else:
			d[i]=1
	flag=1
	s=sorted(list(set(l)),reverse=True)
	t=len(s)
	su=0
	h=n//2
	z=[]
	q=0
	for i in s:
		if su+d[i]<=h:
			z.append(d[i])
			su+=d[i]
			q+=1
		else:
			break
	if q>=3:
		g=z[0]
		si=0
		b=0
		for i in range(1,q):
			si+=z[i]
			if si>g:
				break
		if i<q:
			b=sum(z[i+1:])
		else:
			flag=0
		if g<si and g<b:
			print(g,si,b)
		else:
			flag=0
	else:
		flag=0
	if flag==0:
		print(0,0,0)
